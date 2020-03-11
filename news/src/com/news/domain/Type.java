package com.news.domain;

import java.sql.Date;

/**
 * Created by WXY on 2018/12/21 0021 上午 10:05
 */
public class Type {
        private int type_id;
        private String type_name;
        private Date type_date;

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public Date getType_date() {
        return type_date;
    }

    public void setType_date(Date type_date) {
        this.type_date = type_date;
    }
}
