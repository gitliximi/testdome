package com.lxm.websocketdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
//开启对websocket的支持
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {

    //注册stomp节点，映射制定URL
    //@Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //注册节点并制定sockejs协议
        registry.addEndpoint("/endpointWebsocket").withSockJS();

    }

    //配置信息代理
    //@Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //注册一个广播式信息代理
        registry.enableSimpleBroker("/topic");

    }
}
