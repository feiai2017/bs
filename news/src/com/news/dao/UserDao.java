package com.news.dao;

import com.news.domain.User;
import com.news.utils.Tool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WXY on 2018/12/17 0017 上午 10:58
 */
public class UserDao {

    /**
     * 登录功能
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public User CkeckLogin(String username,String password) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        User user=null;
        Connection connection = Tool.getConnection();
            ps = connection.prepareStatement("select * from n_user where user_name=? and user_password=?");
            ps.setString(1,username);
            ps.setString(2,password);
            rs= ps.executeQuery();
            while (rs.next()){
                user=new User();
                user.setUser_id(rs.getInt(1));
                user.setUser_name(rs.getString(2));
                user.setUser_password(rs.getString(3));
                user.setSuperFlag(rs.getInt(4));
                user.setComment(rs.getString(5));
            }
    return user;

    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    public int AddUser(User user){
        Connection connection = Tool.getConnection();
        PreparedStatement ps=null;
        try {
           ps = connection.prepareStatement("insert into n_user values (null ,?,?,?,?)");
           ps.setString(1,user.getUser_name());
           ps.setString(2,user.getUser_password());
           ps.setInt(3,user.getSuperFlag());
           ps.setString(4,user.getComment());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Tool.colse(ps,connection );
        }

        return 0;
    }

    /**
     *
     *查询所有用户
     * @return 用户集合
     */
    public List<User> userList(){
        ArrayList<User> list = new ArrayList<>();
        Connection connection = Tool.getConnection();
        PreparedStatement ps=null;
        ResultSet rs;
        try {
            ps = connection.prepareStatement("select * from n_user");
            rs = ps.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setUser_id(rs.getInt(1));
                user.setUser_name(rs.getString(2));
                user.setUser_password(rs.getString(3));
                user.setSuperFlag(rs.getInt(4));
                user.setComment(rs.getString(5));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
                    Tool.colse(ps,connection );
        }
        return list;
    }

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    public User UserInfo(int id){
        Connection connection = Tool.getConnection();
        PreparedStatement ps=null;
        ResultSet rs;
        User  user=new User();
        try {
            ps = connection.prepareStatement("select * from n_user where user_id=?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                user.setUser_id(rs.getInt(1));
                user.setUser_name(rs.getString(2));
                user.setUser_password(rs.getString(3));
                user.setSuperFlag(rs.getInt(4));
                user.setComment(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Tool.colse(ps,connection );
        }
        return user;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     * @throws SQLException
     */
    public int editUser(User user) throws SQLException {
        Connection connection = Tool.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        ps=connection.prepareStatement("update n_user set user_name=?,user_password=?,superFlag=?,comment=? where user_id=?");
        ps.setString(1,user.getUser_name());
        ps.setString(2,user.getUser_password());
        ps.setInt(3,user.getSuperFlag());
        ps.setString(4,user.getComment());
        ps.setInt(5,user.getUser_id());
        int i = ps.executeUpdate();

            Tool.colse(ps,connection );
        return i;
    }

    /**
     * 删除用户
     * @param id 用户id
     * @return
     */
    public int deletUser(int id){
        Connection connection = Tool.getConnection();
        PreparedStatement ps=null;
        try {
            ps = connection.prepareStatement("delete from n_user where user_id=?");
            ps.setInt(1,id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Tool.colse(ps,connection );
        }
        return  0;
    }
}
