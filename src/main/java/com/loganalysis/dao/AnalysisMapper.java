package com.loganalysis.dao;

import com.loganalysis.entity.TAnalysis;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/14 10:27 下午
 */
@Mapper
public interface AnalysisMapper {
    int insertAnalysis(List<TAnalysis> tAnalysis);

    List<Map<String, String>> getCity();

    List<Map<String, String>> getPlatform();

    List getWeek();

    List<Map<String, String>> getvideoInfo();

    List<Map> queryVideoByHour(String videoName);

    List<Map> queryVideoByDay(String videoName);

    List<Map> queryVideoByMonth(String videoName);
}
