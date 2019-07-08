package com.lxm.websocketdemo.controller;

import com.lxm.websocketdemo.pojo.SocketMessage;
import com.lxm.websocketdemo.pojo.SocketResponse;
import com.lxm.websocketdemo.service.TaskService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WebSocketController {

    @Resource
    private TaskService taskService;

    //当浏览器向服务器发送stomp请求时，通过@MessageMapping映射地址
    @MessageMapping("/getServerTime")
    //当服务器有消息时，向订阅了sendto的浏览器发送信息
    @SendTo("/topic/getResponse")
    public SocketMessage sendServerTime(SocketMessage socketMessage) {
        if("uuid".equals(socketMessage.getKey())){
            return socketMessage;
        }else{
            Map<String,String> map = new HashMap<>();
            map.put("message",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            return new SocketMessage("time",map);
        }
    }

    @RequestMapping("/index")
    public String toPage() {
        return "webSocket";
    }
}
