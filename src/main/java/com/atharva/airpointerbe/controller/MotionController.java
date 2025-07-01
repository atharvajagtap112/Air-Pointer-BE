package com.atharva.airpointerbe.controller;



import com.atharva.airpointerbe.Model.MotionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class MotionController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // Flutter sends data to /app/move
    @MessageMapping("/move")
    public void receiveMotion(MotionData motionData) {



        if (motionData.getAction() != null) {
            String action = motionData.getAction();

            if (action.equals("scroll")){
                messagingTemplate.convertAndSend("/topic/move", Map.of(
                                                                        "action", action,
                                                                       "scroll_dy", motionData.getScroll_dy()));
            }
            else {
                messagingTemplate.convertAndSend("/topic/move", Map.of("action", action));

            }

                  return;
        }

        // If no action, treat as movement
        double dx = motionData.getDx();
        double dy = motionData.getDy();

        messagingTemplate.convertAndSend("/topic/move", Map.of(
                "dx", dx,
                "dy", dy
        ));
    }
}
