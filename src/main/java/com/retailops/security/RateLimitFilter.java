package com.retailops.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RateLimitFilter extends OncePerRequestFilter {

    private static final int MAX_REQUESTS = 20;
    private static final long WINDOW_SECONDS = 60;

    private final Map<String, RequestInfo> requestCounts = new ConcurrentHashMap<>();

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String clientIP = request.getRemoteAddr();

        RequestInfo info = requestCounts.getOrDefault(clientIP, new RequestInfo());

        long currentTime = Instant.now().getEpochSecond();

        if (currentTime - info.timestamp > WINDOW_SECONDS) {
            info.count = 0;
            info.timestamp = currentTime;
        }

        info.count++;

        requestCounts.put(clientIP, info);

        if (info.count > MAX_REQUESTS) {
            response.setStatus(429);
            response.getWriter().write("Too many requests. Try again later.");
            return;
        }

        filterChain.doFilter(request, response);
    }

    static class RequestInfo {
        int count = 0;
        long timestamp = Instant.now().getEpochSecond();
    }
}
