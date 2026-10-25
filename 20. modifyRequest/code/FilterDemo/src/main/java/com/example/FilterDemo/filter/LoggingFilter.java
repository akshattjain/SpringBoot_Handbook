package com.example.FilterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(2)
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

//        System.out.println("Request entered in logging filter.");
//
//        filterChain.doFilter(servletRequest,servletResponse);
//
//        System.out.println("Request exiting in Logging Filter.");

        long startTime =System.currentTimeMillis();

        HttpServletRequest httpRequest =(HttpServletRequest) servletRequest;


        HttpServletResponse httpResponse =(HttpServletResponse) servletResponse;


        String requestId= UUID.randomUUID().toString();

        httpResponse.setHeader("X-Request-ID",requestId);

        System.out.println("Incoming request : "
                + httpRequest.getMethod() +
                httpRequest.getRequestURL());

        filterChain.doFilter(servletRequest , servletResponse);

        long duration =System.currentTimeMillis()-startTime;

        System.out.println("Response status : "+
                httpResponse.getStatus());


        System.out.println("API response time : "+duration);
    }



}
