package com.news.service;


import com.news.dao.UserDao;
import com.news.domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by WXY on 2018/12/17 0017 上午 11:14
 */
public class UserService  {
    private  UserDao userDao = new UserDao();

    /**
     * 判断用户名密码
     * @param username 用户名
     * @param password 密码
     * @return User对象
     */
    public User checkLogin(String username,String password){

        try {
          return  userDao.CkeckLogin(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 添加用户
     * @param user 用户对象
     * @return  更新数据的条数
     */
    public int AddUser(User user){
        int i = userDao.AddUser(user);
        return i;
    }

    /**
     * 查询所有用户
     * @return 用户集合
     */
    public List<User> userList(){
        List<User> users = userDao.userList();
        return users;
    }

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    public User UserInfo(int id){
        User user = userDao.UserInfo(id);
        return user;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public int editUser(User user)  {
        int i = 0;
        try {
            i = userDao.editUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public int deleteUser(int id){
        return userDao.deletUser(id);
    }
}
