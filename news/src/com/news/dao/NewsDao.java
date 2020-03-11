package com.news.dao;

import com.news.domain.News;
import com.news.utils.Tool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WXY on 2018/12/21 0021 下午 4:05
 */
public class NewsDao {

    /**
     * 添加新闻
     *
     * @param news
     * @return
     */
    public int addNews(News news) {
        Connection connection = Tool.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("insert into n_news values (null ,?,?,?,?,?,null ,?)");
            ps.setString(1, news.getNews_title());
            ps.setString(2, news.getNews_type());
            ps.setString(3, news.getNews_keyword());
            ps.setInt(4, news.getNews_check());
            ps.setString(5, news.getNews_content());
            ps.setDate(6, news.getNews_date());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Tool.colse(ps, connection);
        }
        return 0;
    }

    /**
     * 获取所有新闻
     *
     * @return
     */
    public List<News> getNewsList() {
        List<News> newsList = new ArrayList<>();
        Connection connection = Tool.getConnection();
        PreparedStatement ps = null;
        News news = null;
        try {
            ps = connection.prepareStatement("select * from n_news");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                news = new News();
                news.setNews_id(rs.getInt(1));
                news.setNews_title(rs.getString(2));
                news.setNews_type(rs.getString(3));
                news.setNews_keyword(rs.getString(4));
                news.setNews_check(rs.getInt(5));
                news.setNews_content(rs.getString(6));
                news.setNews_date(rs.getDate(8));
                newsList.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Tool.colse(ps, connection);
        }
        return newsList;
    }

    /**
     * 根据id删除新闻
     *
     * @param id
     * @return
     */
    public int deleteNews(int id) {
        Connection connection = Tool.getConnection();
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement("delete from n_news where news_id=?");
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Tool.colse(ps, connection);
        }
        return 0;
    }

    /**
     * 根据新闻id获取新闻信息
     *
     * @param id
     * @return
     */
    public News newsInfo(int id) {
        Connection connection = Tool.getConnection();
        PreparedStatement ps = null;
        News news = null;
        try {
            ps = connection.prepareStatement("select * from n_news where news_id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                news = new News();
                news.setNews_id(rs.getInt(1));
                news.setNews_title(rs.getString(2));
                news.setNews_type(rs.getString(3));
                news.setNews_keyword(rs.getString(4));
                news.setNews_check(rs.getInt(5));
                news.setNews_content(rs.getString(6));
                news.setNews_date(rs.getDate(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Tool.colse(ps, connection);
        }
        return news;
    }


    /**
     * 修改新闻信息
     * @param news
     * @return
     */
    public int editNews(News news) {
        Connection connection = Tool.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("update  n_news set news_title=? , news_type=? , news_keyword=? , news_check=? ,news_content=? , news_date=? where news_id=?");
            ps.setString(1, news.getNews_title());
            ps.setString(2, news.getNews_type());
            ps.setString(3, news.getNews_keyword());
            ps.setInt(4, news.getNews_check());
            ps.setString(5, news.getNews_content());
            ps.setDate(6, news.getNews_date());
            ps.setInt(7,news.getNews_id());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Tool.colse(ps, connection);
        }
        return 0;
    }

}