package com.news.domain;

import java.sql.Date;

/**
 * Created by WXY on 2018/12/21 0021 下午 2:29
 */
public class News {

    private int news_id;
    private String news_title;
    private String news_type;
    private String news_keyword;
    private int news_check;
    private String news_content;
    private String news_image;
    private Date news_date;

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_type() {
        return news_type;
    }

    public void setNews_type(String news_type) {
        this.news_type = news_type;
    }

    public String getNews_keyword() {
        return news_keyword;
    }

    public void setNews_keyword(String news_keyword) {
        this.news_keyword = news_keyword;
    }

    public int getNews_check() {
        return news_check;
    }

    public void setNews_check(int news_check) {
        this.news_check = news_check;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public String getNews_image() {
        return news_image;
    }

    public void setNews_image(String news_image) {
        this.news_image = news_image;
    }

    public Date getNews_date() {
        return news_date;
    }

    public void setNews_date(Date news_date) {
        this.news_date = news_date;
    }
}
