package com.loganalysis.service.impl;

import com.loganalysis.dao.AnalysisMapper;
import com.loganalysis.entity.TAnalysis;
import com.loganalysis.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/14 10:26 下午
 */
@Service
public class AnalysisServiceImpl implements AnalysisService {
    @Autowired
    AnalysisMapper analysisMapper;
    @Override
    public int insertAnalysis(List<TAnalysis> tAnalysis) {
        return analysisMapper.insertAnalysis(tAnalysis);
    }

    @Override
    public List<Map<String, String>> getCity() {
        return analysisMapper.getCity();
    }

    @Override
    public List<Map<String, String>> getPlatform() {
        return analysisMapper.getPlatform();
    }

    @Override
    public List getWeek() {
        return analysisMapper.getWeek();
    }

    @Override
    public List<Map<String, String>> getvideoInfo() {
        return analysisMapper.getvideoInfo();
    }

    @Override
    public List<Map> queryVideoByHour(String videoName) {
        return analysisMapper.queryVideoByHour(videoName);
    }

    @Override
    public List<Map> queryVideoByDay(String videoName) {
        return analysisMapper.queryVideoByDay(videoName);
    }

    @Override
    public List<Map> queryVideoByMonth(String videoName) {
        return analysisMapper.queryVideoByMonth(videoName);
    }

}
