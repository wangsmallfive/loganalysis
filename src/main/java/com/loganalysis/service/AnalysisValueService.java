package com.loganalysis.service;

import com.loganalysis.entity.TAnalysisValue;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/17 3:05 下午
 */
@Component
public interface AnalysisValueService {
    int insertAnalysisValue(List<TAnalysisValue> analysisValues);
    int deleteAnalysisValue();

    List<Map<String, String>> getCity();

    List<Map<String, String>> getPlatform();

    List getWeek();
}
