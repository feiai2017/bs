package com.news.domain;

import java.sql.Date;

/**
 * Created by WXY on 2018/12/21 0021 ?? 2:29
 */
public class Activity{

    private int activity_id;
    private String activity_name;
    private String interviewee;
    private String comment;
    private int superFlag;

    public int getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getInterviewee() {
        return interviewee;
    }

    public void setInterviewee(String interviewee) {
        this.interviewee = interviewee;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getSuperFlag() {
        return superFlag;
    }

    public void setSuperFlag(int superFlag) {
        this.superFlag = superFlag;
    }
}
