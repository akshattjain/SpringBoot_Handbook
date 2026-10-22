package com.example.FilterDemo.filter;

import jakarta.servlet.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        System.out.println("Request entered in logging filter.");

        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("Request exiting in Logging Filter.");
    }

}
