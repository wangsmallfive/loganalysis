package com.loganalysis.controller;

import com.loganalysis.util.FilesCvs;
import com.loganalysis.util.HiveSQL;
import com.loganalysis.util.ResObject;
import com.loganalysis.util.SimpleHttpClientUtil;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/18 12:02 下午
 */
@Controller
public class FileForCsv {

    @Autowired
    HiveSQL hiveSQL;
    @Autowired
    SimpleHttpClientUtil simpleHttpClientUtil;
    @Autowired
    ResObject resultData;
    @RequestMapping("/searchHive")
    public ResObject searchHive(){
        //开始生成日志内容并返回日志地址
        String filePath = FilesCvs.writeCsv();
        try {
            //将日志文件上传至hadoop
            simpleHttpClientUtil.importOnetimeDataPlan(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理分析日志并后返回结果
        hiveSQL.createHive();
        return resultData.ResSuccess(true);
    }
}
