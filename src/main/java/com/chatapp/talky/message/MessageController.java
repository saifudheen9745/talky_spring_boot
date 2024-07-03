package com.chatapp.talky.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MessageController {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;
    @Autowired
    private MessageService messageService;

    @MessageMapping("/chat/{roomId}/sendMessage")
    public void sendMessage(@DestinationVariable String roomId,@Payload String msg){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Message message = objectMapper.readValue(msg, new TypeReference<Message>() {});
            Boolean saved = this.messageService.saveMessage(message);
            if(saved){
                messagingTemplate.convertAndSend("/room/"+roomId, message);
            }
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }
}
