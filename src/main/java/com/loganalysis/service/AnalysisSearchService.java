package com.loganalysis.service;

import com.loganalysis.entity.TAnalysisSearch;
import com.loganalysis.entity.TAnalysisValue;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/17 4:56 下午
 */
@Component
public interface AnalysisSearchService {
    int insertAnalysisSearch(List<TAnalysisSearch> analysisSearches);
    int deleteAnalysisSearch();

    List<Map<String, String>> getvideoInfo();

    List<Map> queryVideoByHour(String videoName);

    List<Map> queryVideoByDay(String videoName);

    List<Map> queryVideoByMonth(String videoName);
}
