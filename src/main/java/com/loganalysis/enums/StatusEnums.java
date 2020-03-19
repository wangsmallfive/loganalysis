package com.loganalysis.enums;

public enum StatusEnums {
    SUCCESS(200, "SUCCESS"),
    SERVICE_ERROR(500, "服务器内部错误"),
    NORMAL_ERROR(400, "ERROR"),
    NOT_LOGIN(401, "尚未认证，认证失败"),
    PASSWORD_ERROR(201, "用户名密码错误");

    private int status;
    private String msg;

    private StatusEnums(int status, String msg) {
        this.status = status;
        this.msg = msg;
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
}
