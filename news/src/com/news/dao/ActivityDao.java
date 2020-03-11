package com.news.dao;

import com.news.domain.Activity;
import com.news.utils.Tool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WXY on 2018/12/21 0021 ?? 4:05
 */
public class ActivityDao {

    /**
     * ????
     *
     * @param activity
     * @return
     */
    public int addActivity(Activity activity) {
        Connection connection = Tool.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("insert into n_activity values (null ,?,?,?,?)");
            ps.setString(1, activity.getActivity_name());
            ps.setString(2, activity.getInterviewee());
            ps.setInt(3, activity.getSuperFlag());
            ps.setString(4, activity.getComment());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Tool.colse(ps, connection);
        }
        return 0;
    }

    /**
     * ????????
     *
     * @return
     */
    public List<Activity> getActivityList() {
        List<Activity> newsList = new ArrayList<>();
        Connection connection = Tool.getConnection();
        PreparedStatement ps = null;
        Activity news = null;
        try {
            ps = connection.prepareStatement("select * from n_activity");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                news = new Activity();
                news.setActivity_id(rs.getInt(1));
                news.setActivity_name(rs.getString(2));
                news.setInterviewee(rs.getString(3));
                news.setSuperFlag(rs.getInt(4));
                news.setComment(rs.getString(5));
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
     * ??id??????
     *
     * @param id
     * @return
     */
    public int deleteActivity(int id) {
        Connection connection = Tool.getConnection();
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement("delete from n_activity where activity_id=?");
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
     * ????id??????
     *
     * @param id
     * @return
     */
    public Activity activityInfo(int id) {
        Connection connection = Tool.getConnection();
        PreparedStatement ps = null;
        Activity activies = null;
        try {
            ps = connection.prepareStatement("select * from n_activity where activity_id =?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                activies = new Activity();
                activies.setActivity_id(rs.getInt(1));
                activies.setActivity_name(rs.getString(2));
                activies.setInterviewee(rs.getString(3));
                activies.setSuperFlag(rs.getInt(4));
                activies.setComment(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Tool.colse(ps, connection);
        }
        return activies;
    }


    /**
     * ??????
     * @param activity
     * @return
     */
    public int editActivity(Activity activity) {
        Connection connection = Tool.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("update  n_activity set activity_name=? , interviewee=? , superFlag=?" +
                    ", " +
                    "comment=? where acitivity_id=?");
            ps.setString(1, activity.getActivity_name());
            ps.setString(2, activity.getInterviewee());
            ps.setInt(3, activity.getSuperFlag());
            ps.setString(4, activity.getComment());
            ps.setInt(5,activity.getActivity_id());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Tool.colse(ps, connection);
        }
        return 0;
    }

}