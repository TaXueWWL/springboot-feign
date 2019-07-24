package com.snowalker.springboot.feignclient.entity;

/**
 * @author snowalker
 * @version 1.0
 * @date 2019/7/24 16:37
 * @className DemoResp
 * @desc
 */
public class DemoResp {

    private String name;

    private String age;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setAge(String age){
        this.age = age;
    }
    public String getAge(){
        return this.age;
    }
}
