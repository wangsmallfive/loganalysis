package com.loganalysis.util;

import com.loganalysis.entity.TAnalysisSearch;
import com.loganalysis.entity.TAnalysisValue;
import com.loganalysis.service.AnalysisSearchService;
import com.loganalysis.service.AnalysisValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/17 12:20 上午
 */
@Component
public class HiveSQL {
    @Autowired
    AnalysisSearchService analysisSearchService;
    @Autowired
    AnalysisValueService analysisValueService;
    public void createHive(){
        String driverName = "org.apache.hive.jdbc.HiveDriver";
        String url = "jdbc:hive2://192.168.99.100:60007/default";
        Connection connection = null;
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url,"root","1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        String truncateTable="truncate table t_analysis";
        String load="load data inpath '/t_analysis.csv' into table t_analysis";
        try {
            runSql(truncateTable,connection);
            runSql(load,connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //jdbc：hive2是连接协议 192.168.1.14是hive地址 10000是端口 userdb是连接的数据库

        analysisSearchService.deleteAnalysisSearch();

        String[] analysisSearch = new String[4];
        analysisSearch[0] = "select 'info' as unit,video_name,count(1) as cnt ,max(video_duration) as hours,sum(is_comment) as comment," +
                "sum(is_forward) as forward,sum(is_like) as isLike from t_analysis group by video_name";
        //按小时
        analysisSearch[1] = "select 'week' as unit,video_name ,count(1) as cnt,from_unixtime(unix_timestamp(create_time),'yyyy-MM-dd HH:00') hours, \n" +
                "                                      sum(is_comment) as comment,sum(is_forward) as forward,sum(is_like) as isLike\n" +
                "                                      from t_analysis where from_unixtime(unix_timestamp(create_time),'yyyy-MM-dd') = from_unixtime(unix_timestamp(),'yyyy-MM-dd') \n" +
                "                                     group by video_name,from_unixtime(unix_timestamp(create_time),'yyyy-MM-dd HH:00')";
        //按天
        analysisSearch[2] = "select 'month'as unit,video_name ,from_unixtime(unix_timestamp(create_time),'yyyy-MM-dd') as hours,count(1) as cnt," +
                "        sum(is_comment) as comment,sum(is_forward) as forward,sum(is_like) as isLike" +
                "        from t_analysis where weekofyear (create_time) = weekofyear (from_unixtime(unix_timestamp(),'yyyy-MM-dd'))" +
                "       and year(create_time) = " + getYear.getSysYear() +
                "        group by video_name,from_unixtime(unix_timestamp(create_time),'yyyy-MM-dd')";
        //按年
        analysisSearch[3] = "select 'year' as unit,video_name ,from_unixtime(unix_timestamp(create_time),'yyyy-MM') as hours,count(1) cnt," +
                "sum(is_comment) as comment,sum(is_forward) as forward,sum(is_like) as isLike   " +
                "from t_analysis where year(create_time) = year(from_unixtime(unix_timestamp(),'yyyy-MM-dd'))  " +
                "group by video_name,from_unixtime(unix_timestamp(create_time),'yyyy-MM')  ";


        for (int i = 0; i < analysisSearch.length; i++) {
            List maps = null;
            try {
                maps = runHive(analysisSearch[i], "search",connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            analysisSearchService.insertAnalysisSearch(maps);
        }

        analysisValueService.deleteAnalysisValue();
        String[] analysisValue = new String[3];
        //各省数据分布sql
        analysisValue[0] = "SELECT 'city' as param,city as name,count(*) as value FROM t_analysis group by city";
        //平台总播放量sql
        analysisValue[1] = "SELECT 'platform' as param,platform as  name,count(*) as value FROM t_analysis group by platform ";
        //本周视频播放量
        analysisValue[2] = "SELECT 'countWeek' as param,'' as name, count(1) as value FROM t_analysis WHERE " +
                "weekofyear(from_unixtime(unix_timestamp(create_time),'yyyy-MM-dd')) = weekofyear(from_unixtime(unix_timestamp(),'yyyy-MM-dd')) " +
                "and year(create_time) = "+ getYear.getSysYear() +"" +
                " group by from_unixtime(unix_timestamp(create_time),'yyyy-MM-dd') ";
        for(int i =0 ;i<analysisValue.length;i++){
            List maps = null;
            try {
                maps = runHive(analysisValue[i],"value",connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            analysisValueService.insertAnalysisValue(maps);
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List runHive(String sql,String type,Connection connection) throws  SQLException {
        List returnList = new ArrayList<>();
        //执行sql语句并得到查询结果集
        Statement statement = connection.createStatement();
        ResultSet rs =statement.executeQuery(sql);
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        while (rs.next()) {
            if(type.equals("value")){
                TAnalysisValue map = new TAnalysisValue();
                map.setParam(rs.getString("param"));
                map.setName(rs.getString("name"));
                map.setValue(rs.getString("value"));
                returnList.add(map);
            }else{
                TAnalysisSearch map = new TAnalysisSearch();
                map.setUnit(rs.getString("unit"));
                map.setVideoName(rs.getString("video_name"));
                map.setCnt(rs.getString("cnt"));
                map.setHours(rs.getString("hours"));
                map.setComment(rs.getString("comment"));
                map.setForward(rs.getString("forward"));
                map.setIsLike(rs.getString("isLike"));
                returnList.add(map);
            }
        }
        rs.close();
        statement.close();
        return returnList;
    }
    public Boolean runSql(String sql,Connection connection) throws SQLException {
//        String sql="select *  from t_analysis limit 10";
        //执行sql语句并得到查询结果集
        Statement statement = connection.createStatement();
        boolean rs =statement.execute(sql);
        return rs;
    }

}
