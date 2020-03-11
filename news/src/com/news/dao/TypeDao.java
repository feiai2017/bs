package com.news.dao;

import com.news.domain.Type;
import com.news.utils.Tool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WXY on 2018/12/21 0021 上午 10:11
 */
public class TypeDao {

    /**
     * 添加新闻类型
     * @param type
     * @return
     */
    public int addType(Type type){
        Connection connection = Tool.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("insert into n_newstype values (null ,?,null )");
            ps.setString(1,type.getType_name());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Tool.colse(ps,connection );
        }
        return 0;
    }


    /**
     * 查询所有新闻类型
     * @return
     */
    public List<Type> getTypeList(){
        ArrayList<Type> list = new ArrayList<>();
        Type type=null;
        Connection connection = Tool.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps=connection.prepareStatement("select * from n_newstype");
            rs=ps.executeQuery();
            while (rs.next()){
                type=new Type();
                type.setType_id(rs.getInt(1));
                type.setType_name(rs.getString(2));
                type.setType_date(rs.getDate(3));
                list.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Tool.colse(ps,connection );
        }
        return list;
    }

    /**
     * 删除新闻类型
     * @param id
     * @return
     */
    public int deleteType(int id){
        Connection connection = Tool.getConnection();
        PreparedStatement ps=null;
        try {
            ps = connection.prepareStatement("delete from n_newstype where newstype_id=?");
            ps.setInt(1,id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Tool.colse(ps,connection );
        }
        return  0;
    }


    /**
     * g根据id获取类型信息
     * @param id
     * @return
     */
    public Type infoType(int id){
        Connection connection = Tool.getConnection();
        PreparedStatement ps=null;
        Type type = null;
        try {
            ps = connection.prepareStatement("select * from n_newstype where newstype_id=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                type=new Type();
                type.setType_id(rs.getInt(1));
                type.setType_name(rs.getString(2));
                type.setType_date(rs.getDate(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Tool.colse(ps,connection );
        }
        return type;
    }

    /**
     * 编辑新闻类型
     * @param type
     * @return
     */
    public int editType(Type type){
        Connection connection = Tool.getConnection();
        PreparedStatement ps=null;
        try {
            ps=connection.prepareStatement("update n_newstype set newstype_type=? where newstype_id=?");
            ps.setString(1,type.getType_name());
            ps.setInt(2,type.getType_id());
           return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Tool.colse(ps,connection );
        }
        return 0;
    }

}
