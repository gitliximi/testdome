package com.lxm.websocketdemo.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lxm.websocketdemo.controller.WebSocketController;
import com.lxm.websocketdemo.pojo.SocketMessage;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.SimpleMessageConverter;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@Configuration
public class MessageTask {

    @Resource
    private SimpMessageSendingOperations simpMessagingTemplate;

    int i = 0;

    @Scheduled(cron = "0/5 * * * * *")
    public void task() {
        //System.out.println("开始");
        SocketMessage socketMessage = new SocketMessage();
        Map<String,String> map = new HashMap<>();
        String str = String.valueOf(i++);
        map.put("message",str);
        socketMessage.setKey("uuid");
        socketMessage.setMessage(map);
        simpMessagingTemplate.convertAndSend("/topic/getResponse",socketMessage);
    }
}
