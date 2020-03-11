package com.news.controller;
import com.news.domain.Type;
import com.news.domain.User;
import com.news.service.NewsService;
import com.news.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by WXY on 2018/12/17 0017 上午 11:14
 */
public class UserServlet extends BashServlet{

    private UserService  userdao=new UserService();
    /**
     * 登录功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userdao.checkLogin(username, password);
        if (user!=null){
            //登录成功保存Cookie和session
            Cookie cookie = new Cookie("user",user.getUser_name()+"-"+user.getUser_password());
            cookie.setMaxAge(60*60);
            resp.addCookie(cookie);
            session.setAttribute("user",user);
            resp.sendRedirect("main.jsp");
        }else {

            req.setAttribute("msg","登录失败！账号或者密码错误");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }

    /**
     * 退出功能
     * @param res
     * @param resp
     */
    public void loginOut(HttpServletRequest res,HttpServletResponse resp) throws IOException {
        //清除session
        HttpSession session = res.getSession();
        session.removeAttribute("user");
        //清除cookie
        Cookie[] cookies = res.getCookies();
        for (Cookie c:cookies) {
            if ("user".equals(c.getName())){
                c.setMaxAge(0);
                resp.addCookie(c);
            }
        }
        resp.sendRedirect("index.jsp");
    }

    /**
     * 添加新用户
     * @param res
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void addUser(HttpServletRequest res,HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        //默认普通用户
        int a=0;
        String username = res.getParameter("username");
        String password = res.getParameter("password");
        String content = res.getParameter("content");
        String superFlag = res.getParameter("superFlag");
        if (superFlag!=null) {
            //管理员
            if (superFlag.equals("on")) {
                a = 1;
            }
        }
        user.setSuperFlag(a);
        user.setUser_name(username);
        user.setUser_password(password);
        user.setComment(content);
        int i = userdao.AddUser(user);
        if (i>0){
            res.getRequestDispatcher("/user?method=userList").forward(res,resp);
        }
    }

    /**
     * 获取所有用户
     * @param res
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    public void userList(HttpServletRequest res,HttpServletResponse resp) throws IOException, ServletException {
        res.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        List<User> list = userdao.userList();
        res.setAttribute("list",list);
        res.getRequestDispatcher("userList.jsp").forward(res,resp);
    }

    /**
     * 编辑界面的用户列表
     * @param res
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    public void editUserList(HttpServletRequest res,HttpServletResponse resp) throws IOException, ServletException {
        List<User> list = userdao.userList();
        res.setAttribute("list",list);
        res.getRequestDispatcher("editUser.jsp").forward(res,resp);
    }

    /**
     * 用户信息
     * @param res
     * @param resp
     * @throws IOException
     */
    public void userInfo(HttpServletRequest res,HttpServletResponse resp) throws IOException {
        String id =res.getParameter("user_id");
        int user_id=Integer.parseInt(id);
        User user = userdao.UserInfo(user_id);
        HttpSession session = res.getSession();
        session.setAttribute("user",user);
    }

    /**
     * 编辑用户
     * @param res
     * @param resp
     * @throws ServletException
     * @throws IOException
     * @throws SQLException
     */
    public void editUser(HttpServletRequest res,HttpServletResponse resp) throws ServletException, IOException, SQLException {
        User user = new User();
        //默认普通用户
        int a=0;
        int user_id = Integer.parseInt(res.getParameter("user_id"));
        String username = res.getParameter("username");
        String password = res.getParameter("password");
        String content = res.getParameter("content");
        String superFlag = res.getParameter("superFlag");
        if (superFlag!=null) {
            //管理员
            if (superFlag.equals("on")) {
                a = 1;
            }
        }
        user.setSuperFlag(a);
        user.setUser_name(username);
        user.setUser_password(password);
        user.setComment(content);
        user.setUser_id(user_id);
        int i = userdao.editUser(user);
        if (i>0){
            res.getRequestDispatcher("/user?method=userList").forward(res,resp);
        }
    }

    /**
     * 删除用户
     * @param res
     * @param resp
     * @throws IOException
     */
    public void deleteUser(HttpServletRequest res,HttpServletResponse resp) throws IOException{
        int id = Integer.parseInt(res.getParameter("user_id"));
        int i = userdao.deleteUser(id);
    }
}



