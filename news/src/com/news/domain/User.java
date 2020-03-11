package com.news.domain;

/**
 * Created by WXY on 2018/12/17 0017 上午 10:53
 */
public class User {

    private int user_id;
    private String user_name;
    private String user_password;
    private int superFlag;
    private String comment;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public int getSuperFlag() {
        return superFlag;
    }

    public void setSuperFlag(int superFlag) {
        this.superFlag = superFlag;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
