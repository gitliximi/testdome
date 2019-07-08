package com.lxm.websocketdemo.pojo;

import java.util.Map;

//浏览器向服务发送的信息实体
public class SocketMessage {

    private String key;

    private Map<String,String> message;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map<String, String> getMessage() {
        return message;
    }

    public void setMessage(Map<String, String> message) {
        this.message = message;
    }

    public SocketMessage(String key, Map<String, String> message) {
        this.key = key;
        this.message = message;
    }

    public SocketMessage(){}

}
