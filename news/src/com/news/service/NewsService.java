package com.news.service;

import com.news.dao.NewsDao;
import com.news.dao.TypeDao;
import com.news.domain.News;
import com.news.domain.Type;

import java.util.List;

/**
 * Created by WXY on 2018/12/21 0021 上午 10:40
 */
public class NewsService {
    private TypeDao typeDao=new TypeDao();
    private NewsDao newsDao=new NewsDao();

    /**
     * 添加新闻类型
     * @param type
     * @return
     */
    public int addType(Type type){
        return typeDao.addType(type);
    }

    /**
     * 查询所有新闻类型
     * @return
     */
    public List<Type> getTypeList(){
        return typeDao.getTypeList();
    }

    /**
     * 删除新闻类型
     * @param id
     * @return
     */
    public int deleteType(int id){
       return typeDao.deleteType(id);
    }

    /**
     *根据id获取类型信息
     * @param id
     * @return
     */
    public Type infoType(int id){
       return typeDao.infoType(id);
    }

    /**
     * 编辑新闻类型
     * @param type
     * @return
     */
    public int editType(Type type){
        return typeDao.editType(type);
    }

    /**
     * 添加新闻
     * @param news
     * @return
     */
    public int addNews(News news){
        return newsDao.addNews(news);
    }

    /**
     * 获取所有新闻
     * @return
     */
    public List<News> newsList(){
        return newsDao.getNewsList();
    }

    /**
     * 根据id删除新闻
     * @param id
     * @return
     */
    public int deleteNews(int id){
        return newsDao.deleteNews(id);
    }

    /**
     * 根据新闻id获取详细信息
     * @param id
     * @return
     */
    public News newsInfo(int id){
        return newsDao.newsInfo(id);
    }


    /**
     * 修改新闻信息
     * @param news
     * @return
     */
    public int editNews(News news){
        return newsDao.editNews(news);
    }
}


