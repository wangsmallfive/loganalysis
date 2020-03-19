package com.loganalysis.service.impl;

import com.loganalysis.dao.AnalysisValueMapper;
import com.loganalysis.entity.TAnalysisValue;
import com.loganalysis.service.AnalysisValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/17 3:05 下午
 */
@Service
public class AnalysisValueServiceImpl implements AnalysisValueService {
    @Autowired
    AnalysisValueMapper analysisValueMapper;
    @Override
    public int insertAnalysisValue(List<TAnalysisValue> analysisValues) {
        return analysisValueMapper.insertAnalysisValue(analysisValues);
    }

    @Override
    public int deleteAnalysisValue() {
        return analysisValueMapper.deleteAnalysisValue();
    }

    @Override
    public List<Map<String, String>> getCity() {
        return analysisValueMapper.getCity();
    }

    @Override
    public List<Map<String, String>> getPlatform() {
        return analysisValueMapper.getPlatform();
    }

    @Override
    public List getWeek() {
        return analysisValueMapper.getWeek();
    }
}
