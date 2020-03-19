package com.loganalysis.dao;

import com.loganalysis.entity.TAnalysisValue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/17 3:07 下午
 */
@Mapper
public interface AnalysisValueMapper {
    int insertAnalysisValue(List<TAnalysisValue> analysisValues);

    int deleteAnalysisValue();

    List<Map<String, String>> getCity();

    List<Map<String, String>> getPlatform();
    List getWeek();
}
