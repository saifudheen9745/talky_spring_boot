package com.chatapp.talky.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {


    @Autowired
    private MessageRespository messageRespository;

    public boolean saveMessage(Message msg){
        try {
            this.messageRespository.save(msg);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return true;
    }

    public List<Message> getAllMessage(String userId1, String userId2){
        List<Message> messages = null;
        try {
            messages = this.messageRespository.findMessagesBetweenUsers(Long.valueOf(userId1), Long.valueOf(userId2));
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return messages;
    }
}
