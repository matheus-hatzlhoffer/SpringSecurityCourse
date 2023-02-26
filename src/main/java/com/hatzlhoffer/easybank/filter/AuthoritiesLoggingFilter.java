package com.hatzlhoffer.easybank.filter;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.util.logging.Logger;

public class AuthoritiesLoggingFilter implements Filter {

    private final Logger LOG = Logger.getLogger(AuthoritiesLoggingFilter.class.getName());

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            LOG.info("User " + authentication.getName() + "is successfully authenticated and has the authorities "
                    + authentication.getAuthorities().toString());
        }

        chain.doFilter(request, response);
    }

}
