package com.loganalysis.util;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/18 12:04 下午
 */
@Component
public class FilesCvs {

    public static String  writeCsv(){
        try {
            OutputStream fos = new FileOutputStream("src/main/resources/cvs/t_analysis.csv");
            for (int i = 0; i < 200000; i++) {
                String outLog = (i+1)+","+outLog();
                String newLine = System.getProperty("line.separator");
                fos.write(outLog.getBytes("UTF-8"));    //将字符串变成字节byte数组，使用UTF-8编码
                fos.write(newLine.getBytes());
            }
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "src/main/resources/cvs/t_analysis.csv";
    }
    //综合随机
    public static String outLog() {
        String returnString = new String();
//        //随机生成IP
//        String randomIp = getRandomIp();
        //随机生成时间
        Date date = randomDate("2020-01-01","2020-12-13");
        //随机生成视频名称
        Random random = new Random();
        int a=random.nextInt(10);
        String[] name = randomString(a);
        //随机生成短视频平台
        int b=random.nextInt(5);
        String video = randomPlatform(b);
        //随机生成用户ID
        getStringRandom(10);
        returnString=name[0]+","+getCity()+","+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date)+","+name[1]+","+random.nextInt(101)+","+video+
                ","+random.nextInt(2)+","+random.nextInt(2)+","+random.nextInt(2);
        return returnString;

    }
    //随机生成IP地址
    public static String getRandomIp() {

        // ip范围
        int[][] range = { { 607649792, 608174079 }, // 36.56.0.0-36.63.255.255
                { 1038614528, 1039007743 }, // 61.232.0.0-61.237.255.255
                { 1783627776, 1784676351 }, // 106.80.0.0-106.95.255.255
                { 2035023872, 2035154943 }, // 121.76.0.0-121.77.255.255
                { 2078801920, 2079064063 }, // 123.232.0.0-123.235.255.255
                { -1950089216, -1948778497 }, // 139.196.0.0-139.215.255.255
                { -1425539072, -1425014785 }, // 171.8.0.0-171.15.255.255
                { -1236271104, -1235419137 }, // 182.80.0.0-182.92.255.255
                { -770113536, -768606209 }, // 210.25.0.0-210.47.255.255
                { -569376768, -564133889 }, // 222.16.0.0-222.95.255.255
        };

        Random rdint = new Random();
        int index = rdint.nextInt(10);
        String ip = num2ip(range[index][0] + new Random().nextInt(range[index][1] - range[index][0]));
        return ip;
    }
    public static String getCity(){
        String citys[] = {"北京","广东","山东","江苏","河南","上海","河北","浙江","香港","山西","陕西","湖南","重庆"
                ,"福建","天津","云南","四川","广西","安徽","海南","江西","湖北","山西","辽宁","内蒙古"
                ,"黑龙江","吉林","甘肃","宁夏","青海","西藏","新疆"};

        Random random = new Random();
        int randomInt = random.nextInt(10000)%citys.length;
        return citys[randomInt];
    }

    /*
     * 将十进制转换成IP地址
     */
    public static String num2ip(int ip) {
        int[] b = new int[4];
        String x = "";
        b[0] = (int) ((ip >> 24) & 0xff);
        b[1] = (int) ((ip >> 16) & 0xff);
        b[2] = (int) ((ip >> 8) & 0xff);
        b[3] = (int) (ip & 0xff);
        x = Integer.toString(b[0]) + "." + Integer.toString(b[1]) + "." + Integer.toString(b[2]) + "." + Integer.toString(b[3]);

        return x;
    }
    //随机生成日期时间

    private static Date randomDate(String beginDate, String endDate){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);
            Date end = format.parse(endDate);

            if(start.getTime() >= end.getTime()){
                return null;
            }
            long date = random(start.getTime(),end.getTime());
            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin,long end){
        long rtn = begin + (long)(Math.random() * (end - begin));
        if(rtn == begin || rtn == end){
            return random(begin,end);
        }
        return rtn;
    }
    //随机生成视频名称
    private static String[] randomString(int i){
        String[][] str=new String[10][2];
        str[0][0]= "视频1";
        str[0][1]= "10:36";
        str[1][0]= "视频2";
        str[1][1]= "8:32";
        str[2][0]= "视频3";
        str[2][1]= "3:15";
        str[3][0]= "视频4";
        str[3][1]= "6:46";
        str[4][0]= "视频5";
        str[4][1]= "8:51";
        str[5][0]= "视频6";
        str[5][1]= "8:39";
        str[6][0]= "视频7";
        str[6][1]= "7:47";
        str[7][0]= "视频8";
        str[7][1]= "9:49";
        str[8][0]= "视频9";
        str[8][1]= "12:12";
        str[9][0]= "视频10";
        str[9][1]= "3:25";

        return str[i];

    }
    //随机生成视频平台
    private static String randomPlatform(int i){
        String[] str=new String[5];
        str[0]= "抖音";
        str[1]= "秒拍";
        str[2]= "微视";
        str[3]= "美拍";
        str[4]= "快手";
        return str[i];

    }
    //自动生成名字（中文）
    public static String getRandomJianHan(int len) {
        String ret = "";
        for (int i = 0; i < len; i++) {
            String str = null;
            int hightPos, lowPos; // 定义高低位
            Random random = new Random();
            hightPos = (176 + Math.abs(random.nextInt(39))); // 获取高位值
            lowPos = (161 + Math.abs(random.nextInt(93))); // 获取低位值
            byte[] b = new byte[2];
            b[0] = (new Integer(hightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try {
                str = new String(b, "GBK"); // 转成中文
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            ret += str;
        }
        return ret;
    }

    //生成随机用户名，数字和字母组成,
    public static String getStringRandom(int length) {

        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
}
