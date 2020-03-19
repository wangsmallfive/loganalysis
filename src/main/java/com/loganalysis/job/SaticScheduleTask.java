package com.loganalysis.job;

import com.loganalysis.controller.AnalysisController;
import com.loganalysis.util.HiveSQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/18 2:58 上午
 */
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {
    @Autowired
    HiveSQL hiveSQL;
    //3.添加定时任务
    @Scheduled(cron = "0 30 0 * * ?")
    //或直接指定时间间隔，例如：每日凌晨12:30分执行
    //@Scheduled(fixedRate=5000)

    private void configureTasks() {
        hiveSQL.createHive();
    }
}