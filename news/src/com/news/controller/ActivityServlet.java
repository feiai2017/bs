package com.news.controller;

import com.news.domain.Activity;
import com.news.domain.Type;
import com.news.service.NewsService;
import com.news.service.ActivityService;

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
public class ActivityServlet extends BashServlet{

    private ActivityService activityService = new ActivityService();

    /**
     * 添加新闻
     * @param res
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    public void addActivity(HttpServletRequest res, HttpServletResponse resp) throws IOException, ServletException{
        int superFlag = 0;
        String activity_name = res.getParameter("activity_name");
        String interviewee = res.getParameter("interviewee");
        String mark = res.getParameter("superFlag");
        String comment = res.getParameter("comment");

        if (mark!=null) {
            if (mark.equals("on")) {
                superFlag = 1;
            }
        }

        Activity activity = new Activity();
        activity.setActivity_name(activity_name);
        activity.setInterviewee(interviewee);
        activity.setSuperFlag(superFlag);
        activity.setComment(comment);

        int i = activityService.addActivity(activity);
        if (i>0){
            res.getRequestDispatcher("/activity?method=activityList").forward(res,resp);
        }

    }

    /**
     * 获取所有采集记录
     * @param res
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    public void activityList(HttpServletRequest res, HttpServletResponse resp) throws IOException, ServletException{
        res.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        List<Activity> activityList = activityService.activityList();
        res.setAttribute("activityList",activityList);
        res.getRequestDispatcher("activityList.jsp").forward(res,resp);
    }


    /**
     * 根据id删除采编记录
     * @param res
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    public void deleteActivity(HttpServletRequest res, HttpServletResponse resp) throws IOException, ServletException{
        int activity_id= Integer.parseInt(res.getParameter("activity_id"));
        System.out.println(activity_id);
        int i = activityService.deleteActivity(activity_id);
        if (i>0){
            res.getRequestDispatcher("/activity?method=activityList").forward(res,resp);
        }
    }

    /**
     * 获取编辑新闻的详细信息跳转到编辑页面
     * @param res
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    public void activityInfo(HttpServletRequest res, HttpServletResponse resp) throws IOException, ServletException{
        int id = Integer.parseInt(res.getParameter("activity_id"));
        Activity activity = activityService.activityInfo(id);
        res.getSession().setAttribute("activity",activity);
    }

    /**
     * 编辑采编
     * @param res
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    public void editActivity(HttpServletRequest res, HttpServletResponse resp) throws IOException, ServletException{
        int activity_id = Integer.parseInt(res.getParameter("activity_id"));
        String activity_name = res.getParameter("name");
        String interviewee = res.getParameter("interviewee");
        int superFlag = Integer.parseInt(res.getParameter("superFlag"));
        String comment = res.getParameter("comment");

        Activity activity = new Activity();
        activity.setActivity_id(activity_id);
        activity.setActivity_name(activity_name);
        activity.setInterviewee(interviewee);
        activity.setSuperFlag(superFlag);
        activity.setComment(comment);

        int i = activityService.editActivity(activity);
        if(i>0){
            res.getRequestDispatcher("/activity?method=activityList").forward(res,resp);
        }
    }


    public void reLoad(HttpServletRequest res, HttpServletResponse resp) throws IOException, ServletException{
        System.out.println("1111");
        PrintWriter out = resp.getWriter();
        out.print("\"addNews.jsp\"");

    }
}
