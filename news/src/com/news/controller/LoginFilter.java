package com.news.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by WXY on 2018/12/17 0017 下午 3:31
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        String url = request.getRequestURI();
        if (url.endsWith("jsp")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            if (session.getAttribute("user") == null) {
                //未登录
                request.getRequestDispatcher("index.jsp").forward(servletRequest, servletResponse);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
