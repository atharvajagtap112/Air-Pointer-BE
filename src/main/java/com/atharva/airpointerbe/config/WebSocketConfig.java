package com.atharva.airpointerbe.config;





import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;



    @Configuration
    @EnableWebSocketMessageBroker
    public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

        @Override
        public void registerStompEndpoints(StompEndpointRegistry registry) {
            // Pure WebSocket without SockJS
            registry.addEndpoint("/ws").setAllowedOrigins("*");
        }

        @Override
        public void configureMessageBroker(MessageBrokerRegistry registry) {
            // Prefix for messages from client to controller
            registry.setApplicationDestinationPrefixes("/app");

            // Prefix for messages from controller to client (subscribed)
            registry.enableSimpleBroker("/topic");
        }
    }


