package com.loganalysis.service.impl;

import com.loganalysis.dao.AnalysisSearchMapper;
import com.loganalysis.entity.TAnalysisSearch;
import com.loganalysis.service.AnalysisSearchService;
import com.loganalysis.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/17 4:57 下午
 */
@Service
public class AnalysisSearchServiceImpl implements AnalysisSearchService {
    @Autowired
    AnalysisSearchMapper analysisSearchMapper;
    @Override
    public int insertAnalysisSearch(List<TAnalysisSearch> analysisSearches) {
        return analysisSearchMapper.insertAnalysisSearch(analysisSearches);
    }

    @Override
    public int deleteAnalysisSearch() {
        return analysisSearchMapper.deleteAnalysisSearch();
    }

    @Override
    public List<Map<String, String>> getvideoInfo() {
        return analysisSearchMapper.getvideoInfo();
    }

    @Override
    public List<Map> queryVideoByHour(String videoName) {
        return analysisSearchMapper.queryVideoByHour(videoName);
    }

    @Override
    public List<Map> queryVideoByDay(String videoName) {
        return analysisSearchMapper.queryVideoByDay(videoName);
    }

    @Override
    public List<Map> queryVideoByMonth(String videoName) {
        return analysisSearchMapper.queryVideoByMonth(videoName);
    }
}
