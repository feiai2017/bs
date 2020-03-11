package com.news.controller;

import com.news.domain.News;
import com.news.domain.Type;
import com.news.service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

/**
 * Created by WXY on 2018/12/21 0021 上午 9:20
 */
public class NewsServlet extends BashServlet{

    private NewsService newsService=new NewsService();
    /**
     * 添加新闻类型
     * @param res
     * @param resp
     * @throws IOException
     */
    public void addType(HttpServletRequest res, HttpServletResponse resp) throws IOException{
        String type_name = res.getParameter("type_name");
        Type type = new Type();
        type.setType_name(type_name);
        newsService.addType(type);
        resp.sendRedirect("news?method=typeList");
    }

    /**
     * 新闻类型列表
     * @param res
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    public void typeList(HttpServletRequest res, HttpServletResponse resp) throws IOException, ServletException {
        List<Type> typeList = newsService.getTypeList();
        res.setAttribute("list",typeList);
        res.getRequestDispatcher("typeList.jsp").forward(res,resp);
    }

    /**
     * 删除新闻类型
     * @param res
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    public void deleteType(HttpServletRequest res, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(res.getParameter("type_id"));
        int i = newsService.deleteType(id);
        if (i>0){
            resp.sendRedirect("user?method=editUserList");
        }
    }

    /**
     * 编辑新闻类型详细
     * @param res
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    public void typeInfo(HttpServletRequest res, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(res.getParameter("type_id"));
        Type type = newsService.infoType(id);
        HttpSession session = res.getSession();
        session.setAttribute("type",type);
    }

    /**
     * 修改x新闻类型
     * @param res
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    public void editType(HttpServletRequest res, HttpServletResponse resp) throws IOException, ServletException {
        String s = res.getParameter("type_name");
       int id = Integer.parseInt(res.getParameter("type_id"));

        Type type = new Type();
        type.setType_id(id);
        type.setType_name(s);
        int i = newsService.editType(type);
        if (i>0){
            res.getRequestDispatcher("/news?method=typeList").forward(res,resp);
        }

    }


    /**
     * 获取新闻类型到select并转到添加新闻界面
     * @param res
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    public void getTypeSelect(HttpServletRequest res, HttpServletResponse resp) throws IOException, ServletException{
        List<Type> typeList = newsService.getTypeList();
        getServletContext().setAttribute("typeList",typeList);
       // res.getRequestDispatcher("addNews.jsp").forward(res,resp);
    }


    /**
     * 添加新闻
     * @param res
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    public void addNews(HttpServletRequest res, HttpServletResponse resp) throws IOException, ServletException{
        String title = res.getParameter("title");
        String type = res.getParameter("news_type");
        String keyword = res.getParameter("keyword");
        int check = Integer.parseInt(res.getParameter("check"));
        Date date = Date.valueOf(res.getParameter("date"));
        String content = res.getParameter("content");

        News news = new News();
        news.setNews_title(title);
        news.setNews_type(type);
        news.setNews_keyword(keyword);
        news.setNews_check(check);
        //没有添加上传图片功能
        news.setNews_image(null);
        news.setNews_content(content);
        news.setNews_date(date);

        int i = newsService.addNews(news);
        if (i>0){
            res.getRequestDispatcher("/news?method=newsList").forward(res,resp);
        }

    }

    /**
     * 获取所有新闻跳转到新闻列表
     * @param res
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    public void newsList(HttpServletRequest res, HttpServletResponse resp) throws IOException, ServletException{
        List<News> newsList = newsService.newsList();
        res.setAttribute("newsList",newsList);
        res.getRequestDispatcher("newsList.jsp").forward(res,resp);

    }


    /**
     * 根据id删除新闻
     * @param res
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    public void deleteNews(HttpServletRequest res, HttpServletResponse resp) throws IOException, ServletException{
        int news_id= Integer.parseInt(res.getParameter("news_id"));
        System.out.println(news_id);
        int i = newsService.deleteNews(news_id);
        if (i>0){
            res.getRequestDispatcher("/news?method=newsList").forward(res,resp);
        }
    }

    /**
     * 获取编辑新闻的详细信息跳转到编辑页面
     * @param res
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    public void newsInfo(HttpServletRequest res, HttpServletResponse resp) throws IOException, ServletException{
        int id = Integer.parseInt(res.getParameter("news_id"));
        News news = newsService.newsInfo(id);
        res.getSession().setAttribute("news",news);
    }

    /**
     * 编辑新闻
     * @param res
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    public void editNews(HttpServletRequest res, HttpServletResponse resp) throws IOException, ServletException{
        int news_id = Integer.parseInt(res.getParameter("news_id"));
        String title = res.getParameter("title");
        String type = res.getParameter("news_type");
        String keyword = res.getParameter("keyword");
        int check = Integer.parseInt(res.getParameter("check"));
        Date date = Date.valueOf(res.getParameter("date"));
        String content = res.getParameter("content");

        News news = new News();
        news.setNews_id(news_id);
        news.setNews_title(title);
        news.setNews_type(type);
        news.setNews_keyword(keyword);
        news.setNews_check(check);
        news.setNews_content(content);
        news.setNews_date(date);

        int i = newsService.editNews(news);
        if(i>0){
            res.getRequestDispatcher("/news?method=newsList").forward(res,resp);
        }
    }


    public void reLoad(HttpServletRequest res, HttpServletResponse resp) throws IOException, ServletException{
        System.out.println("1111");
        PrintWriter out = resp.getWriter();
        out.print("\"addNews.jsp\"");

    }
}
