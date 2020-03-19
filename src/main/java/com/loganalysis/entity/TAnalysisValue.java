package com.loganalysis.entity;

import org.springframework.stereotype.Component;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/17 2:54 下午
 */
@Component
public class TAnalysisValue {
    private Integer id;
    private String param;
    private String name;
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
