package com.labforward.task.dto;

public class ResponseObject {
    private String message;
    private Integer code;
    private Object data;

    public ResponseObject(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public ResponseObject(String message, Integer code, Object data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
