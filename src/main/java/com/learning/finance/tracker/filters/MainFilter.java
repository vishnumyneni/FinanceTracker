package com.learning.finance.tracker.filters;


import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MainFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter: Before processing request");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Filter: After processing request");
    }
}
