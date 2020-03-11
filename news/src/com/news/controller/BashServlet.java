package com.news.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by WXY on 2018/12/17 0017 上午 11:14
 */
public class BashServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        Class clazz = this.getClass();
        try {
            Method m = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            m.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
