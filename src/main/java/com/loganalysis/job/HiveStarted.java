package com.loganalysis.job;

import com.loganalysis.controller.AnalysisController;
import com.loganalysis.service.AnalysisSearchService;
import com.loganalysis.service.AnalysisValueService;
import com.loganalysis.util.HiveSQL;
import com.loganalysis.util.getYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;


/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/17 2:50 下午
 */
@Component
public class HiveStarted {
    @Autowired
    HiveSQL hiveSQL;
    public void setServletContext(ServletContext servletContext) {

        hiveSQL.createHive();

    }

}
