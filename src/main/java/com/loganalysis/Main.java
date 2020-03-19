package com.loganalysis;

import com.loganalysis.entity.TAnalysisSearch;
import com.loganalysis.entity.TAnalysisValue;
import org.apache.hadoop.conf.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/19 1:04 上午
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        String driverName = "org.apache.hive.jdbc.HiveDriver";
        String url = "jdbc:hive2://127.0.0.1:60007/default";
        Connection connection = null;
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url,"root","1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
//        String sql= "truncate table t_analysis";
        String sql="select *  from t_analysis limit 10";
        //执行sql语句并得到查询结果集
        Statement statement = connection.createStatement();
//        boolean rs =statement.execute(sql);
//        System.out.println(rs);
        ResultSet rs =statement.executeQuery(sql);
        ResultSetMetaData metaData = rs.getMetaData();
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        statement.close();
    }



}
