package com.example.FilterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class AuthenticationFilter implements Filter {

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

        HttpServletRequest httpRequest =(HttpServletRequest) servletRequest;


        HttpServletResponse httpResponse =(HttpServletResponse) servletResponse;

        String token= httpRequest.getHeader("token");

        if(token ==null  || !token.equals("12345")){
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        filterChain.doFilter(servletRequest , servletResponse);
    }
}
