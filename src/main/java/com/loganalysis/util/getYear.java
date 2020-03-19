package com.loganalysis.util;

import java.util.Calendar;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/17 5:59 下午
 */
public class getYear {

    public static String getSysYear() {
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        return year;
    }
}
