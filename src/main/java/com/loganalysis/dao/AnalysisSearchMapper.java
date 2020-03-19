package com.loganalysis.dao;

import com.loganalysis.entity.TAnalysisSearch;
import com.loganalysis.entity.TAnalysisValue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/17 4:59 下午
 */
@Mapper
public interface AnalysisSearchMapper {
    int insertAnalysisSearch(List<TAnalysisSearch> analysisSearches);

    int deleteAnalysisSearch();

    List<Map<String, String>> getvideoInfo();

    List<Map> queryVideoByHour(String videoName);

    List<Map> queryVideoByDay(String videoName);

    List<Map> queryVideoByMonth(String videoName);
}
