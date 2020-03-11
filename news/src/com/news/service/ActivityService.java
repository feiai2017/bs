package com.news.service;

import com.news.dao.ActivityDao;
import com.news.domain.Activity;
import com.news.dao.TypeDao;
import com.news.domain.News;
import com.news.domain.Type;

import java.util.List;

/**
 * Created by WXY on 2018/12/21 0021 上午 10:40
 */
public class ActivityService {
    private ActivityDao activityDao = new ActivityDao();

    /**
     * 添加采编
     * @param activity
     * @return
     */
    public int addActivity(Activity activity){
        return activityDao.addActivity(activity);
    }

    /**
     * 获取所有采编记录
     * @return
     */
    public List<Activity> activityList(){
        return activityDao.getActivityList();
    }

    /**
     * 根据id删除采编记录
     * @param id
     * @return
     */
    public int deleteActivity(int id){
        return activityDao.deleteActivity(id);
    }

    /**
     * 根据采编id获取详细信息
     * @param id
     * @return
     */
    public Activity activityInfo(int id){
        return activityDao.activityInfo(id);
    }


    /**
     * 修改采编信息
     * @param activity
     * @return
     */
    public int editActivity(Activity activity){
        return activityDao.editActivity(activity);
    }
}


