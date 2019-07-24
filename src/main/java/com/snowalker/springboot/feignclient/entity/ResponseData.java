package com.snowalker.springboot.feignclient.entity;

/**
 * @author snowalker
 * @version 1.0
 * @date 2019/7/24 16:36
 * @className ResponseData
 * @desc
 */
public class ResponseData<T> {

    private String code;

    private String desc;

    private T data;

    public String getCode() {
        return code;
    }

    public ResponseData<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public ResponseData<T> setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseData<T> setData(T data) {
        this.data = data;
        return this;
    }
}
