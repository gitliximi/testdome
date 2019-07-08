package com.lxm.websocketdemo.pojo;

//服务器向浏览器响应的信息实体
public class SocketResponse {

    private String responseMessage;

    public String getResponseMessage() {
        return responseMessage;
    }

    public SocketResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
