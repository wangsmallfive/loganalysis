package com.loganalysis.util;

import com.loganalysis.enums.CodeEnums;
import com.loganalysis.enums.StatusEnums;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ResObject {

    private int code;
    private int status;
    private String msg;
    private Date timestamp;
    private Object data;
    private String exception;

    public ResObject() {
    }

    public ResObject(int code, int status, String msg, Date timestamp, Object data) {
        this.code = code;
        this.status = status;
        this.msg = msg;
        this.timestamp = timestamp;
        this.data = data;
    }

    public ResObject(int code, int status, String msg, Date timestamp, String exception) {
        this.code = code;
        this.status = status;
        this.msg = msg;
        this.timestamp = timestamp;
        this.exception = exception;
    }

    public ResObject ResSuccess(Object o) {
        return new ResObject(CodeEnums.SUCCESS.getValue(), StatusEnums.SUCCESS.getStatus(),
                StatusEnums.SUCCESS.getMsg(), new Date(), o);
    }

    public ResObject ResErrorCustomer(int status, String msg, String exception) {
        return new ResObject(CodeEnums.FAIL.getValue(), status, msg, new Date(), exception);
    }

    public ResObject ResErrorNormal(String exception) {
        return new ResObject(CodeEnums.FAIL.getValue(), StatusEnums.NORMAL_ERROR.getStatus(),
                StatusEnums.NORMAL_ERROR.getMsg(), new Date(), exception);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "code:" + this.getCode() +
                ",status:" + this.getStatus() +
                ",msg:" + this.getMsg() +
                ",TimeStamp:" + this.getTimestamp() +
                ",data:" + this.getData() +
                ",Exception:" + this.getException();
    }
}
