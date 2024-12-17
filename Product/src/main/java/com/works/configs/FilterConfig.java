package com.works.configs;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class FilterConfig implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURI();
        String ip = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        long time = System.currentTimeMillis();
        String sessionID = request.getSession().getId();

        System.out.println(url + " - " + ip + " - " + userAgent + " - " + time + " - " + sessionID);
        response.setHeader("time", ""+time);

        //PrintWriter printWriter = response.getWriter();
        //printWriter.println("Hello World");
        filterChain.doFilter(request, response);
    }

}
