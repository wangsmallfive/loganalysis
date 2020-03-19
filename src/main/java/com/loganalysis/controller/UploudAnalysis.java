package com.loganalysis.controller;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.URI;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/18 11:10 下午
 */
@Controller
public class UploudAnalysis {
    @RequestMapping("/uploud")
    public void searchHive(){
        Configuration conf = new Configuration();
        //此处的设置必须和core-site.xml配置文件
        conf.set("fs.defaultFS", "hdfs://127.0.0.1:9000");
        conf.set("dfs.replication","1" );
        //conf.set("dfs.datanode.address","hdfs://192.168.0.106:")
//        System.out.println(conf);
        // 文件系统初始化
        FileSystem fs = null;
        try {
            fs = FileSystem.get(URI.create("hdfs://127.0.0.1:9000/"), conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //deleteFile("/t_analysis.csv",fs);
        //createFilePath("/test",fs);
        try {
            updateFile("src/main/resources/cvs/t_analysis.csv",fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void updateFile(String path, FileSystem fs) throws IOException {
        // 要上传的文件
        Path src = new Path(path);
        // 上传到哪
        Path toSrc = new Path("/t_analysis.csv");
        fs.copyFromLocalFile(src, toSrc);
        fs.close();
    }
    //在main函数中进行调用
// //上传文件
// updateFile("/Users/zhangcheng/Desktop/1.png", fs);
    //添加删除文件功能
    public static void deleteFile(String path, FileSystem fs) throws IOException {
        Path src = new Path(path);
        fs.deleteOnExit(src);

    }

    //在main函数中调用
// 删除文件
// deleteFile("/user/root/input/1.png",fs);
    // 创建文件夹
    public static void createFilePath(String path, FileSystem fs) throws IOException {
        Path f = new Path("hdfs://127.0.0.1:60003/" + path);
        fs.mkdirs(f);

    }
}
