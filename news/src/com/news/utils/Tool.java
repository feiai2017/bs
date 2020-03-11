package com.news.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by WXY on 2018/12/17 0017 上午 10:54
 */
public class Tool {
        /**
         * 获取数据库连接
         * @return 连接对象
         */
        public static Connection getConnection(){
            Connection conn=null;
            //阿里云数据库
            String url="JDBC:Mysql://localhost:3306/bs";
            String username="root";
            String password="feiai123";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn= DriverManager.getConnection(url,username,password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return conn;
        }

        /**
         * 关闭数据库连接
         * @param ps
         * @param conn
         */
        public static void colse(PreparedStatement ps, Connection conn){
            if (ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    public static void main(String[] args) {
        Connection connection = Tool.getConnection();
        System.out.println(connection);
    }
}
