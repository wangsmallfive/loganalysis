package com.loganalysis.controller;

import com.loganalysis.entity.Resque;
import com.loganalysis.entity.TAnalysis;
import com.loganalysis.service.AnalysisSearchService;
import com.loganalysis.service.AnalysisService;
import com.loganalysis.service.AnalysisValueService;
import com.loganalysis.util.HiveSQL;
import com.loganalysis.util.getYear;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/14 10:25 下午
 */
@Controller
public class AnalysisController {
    @Autowired
    HiveSQL hiveSQL;

    @Autowired
    AnalysisService analysisService;
    @Autowired
    AnalysisSearchService analysisSearchService;
    @Autowired
    AnalysisValueService analysisValueService;


    @RequestMapping("/queryAnalysis")
    public ModelAndView queryAnalysis() {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("analysis");
        Map map = new HashMap();
        //获取各省播放量
        List<Map<String,String>> city=analysisValueService.getCity();
        List<Map<String,String>> platform=analysisValueService.getPlatform();
        List<Map<String,String>> videoInfo=analysisSearchService.getvideoInfo();
        List week = analysisValueService.getWeek();
        map.put("city",city);
        map.put("platform",platform);
        map.put("week",week);
        mv.addObject("city",city);
        mv.addObject("platform",platform);
        mv.addObject("week",week);
        mv.addObject("videoInfo",videoInfo);
        return mv;
    }
    @ResponseBody
    @RequestMapping("/queryVideo")
    public Map queryVideo(@RequestBody(required=false) Resque resque){
        Map map = new HashMap();
        List<Map> retMap = new ArrayList<>();
        String danwei = resque.getDanwei();
        if(danwei.equals("1")){
            retMap = analysisSearchService.queryVideoByHour(resque.getVideoName());
        }
        if(danwei.equals("2")){
            retMap = analysisSearchService.queryVideoByDay(resque.getVideoName());
        }
        if(danwei.equals("3")){
            retMap = analysisSearchService.queryVideoByMonth(resque.getVideoName());
        }
        map.put("map",retMap);
        return map;
    }



}
