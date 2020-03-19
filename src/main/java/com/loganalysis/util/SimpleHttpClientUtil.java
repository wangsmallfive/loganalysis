package com.loganalysis.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/19 12:27 上午
 */
@Component
public class SimpleHttpClientUtil {
    //根据上传csv文件
    public void importOnetimeDataPlan(String csvUrl) throws Exception {
        String resultData = "";
        // 创建httppost对象
        HttpPost post = null;
        //创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        String url = "http://127.0.0.1:60005/upload_file";
        // 创建uri
        post = new HttpPost(url);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addBinaryBody("file", new File(csvUrl));// 文件路径
        HttpEntity entity = builder.build();// 生成 HTTP POST 实体
        post.setEntity(entity);//设置请求参数  );
        CloseableHttpResponse response = client.execute(post);
        //获取结果实体
        HttpEntity results = response.getEntity();
        String string = "";
        if (results != null) {
            //按指定编码转换结果实体为String类型
            string = EntityUtils.toString(results, "UTF-8");
        }
        System.out.println();
        //释放
        EntityUtils.consume(entity);
        //释放链接
        response.close();
    }

}
