package com.loganalysis.service;

import com.loganalysis.entity.TAnalysis;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/14 10:26 下午
 */
@Component
public interface AnalysisService {
    int insertAnalysis(List<TAnalysis> tAnalysis);
    List<Map<String,String>> getCity();

    List<Map<String, String>> getPlatform();

    List getWeek();

    List<Map<String, String>> getvideoInfo();

    List<Map> queryVideoByHour(String videoName);

    List<Map> queryVideoByDay(String videoName);

    List<Map> queryVideoByMonth(String videoName);
}
