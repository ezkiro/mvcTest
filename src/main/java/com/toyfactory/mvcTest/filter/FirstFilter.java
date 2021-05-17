package com.toyfactory.mvcTest.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class FirstFilter implements Filter {

    @Override
    @Order(1)
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;

        log.debug("[doFilter] request uri:{}",req.getRequestURI());
        chain.doFilter(request, response);
        log.debug("[doFilter] response:{}", res.getContentType());
    }
}
