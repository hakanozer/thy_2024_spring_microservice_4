package com.works.configs;

import com.works.entities.Info;
import com.works.repositories.InfoRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class FilterConfig implements Filter {

    final InfoRepository infoRepository;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = "";
        String roles = "";
        if ( auth != null ) {
            username = auth.getName();
            roles = auth.getAuthorities().toString();
        }
        String url = req.getRequestURI();
        String sessionID = req.getSession().getId();
        String time = ""+System.currentTimeMillis();
        String userAgent = req.getHeader("user-agent");

        Info i = new Info(username, roles, url, sessionID, time, userAgent);
        infoRepository.save(i);

        filterChain.doFilter(req, res);
    }

}
