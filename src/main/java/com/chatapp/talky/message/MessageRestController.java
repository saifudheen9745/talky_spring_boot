package com.chatapp.talky.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.talky.HttpResponse;


@RestController
@RequestMapping(path="/api/v1/user/messages", produces=MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins="http://localhost:4300")
public class MessageRestController {

    @Autowired
    private MessageService messageService;

    @GetMapping()
    public ResponseEntity<HttpResponse>  getAllMessages(@RequestParam String memberA, @RequestParam String memberB) {
        try {
            List<Message> messages = this.messageService.getAllMessage(memberA, memberB);
            if(!messages.isEmpty()){
                return new ResponseEntity<>(new HttpResponse<>("Message List", true, messages), HttpStatus.OK);
            }else {
                throw new IllegalArgumentException("No messages found");
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new HttpResponse<>(e.getMessage(), false, List.of()), HttpStatus.BAD_REQUEST);
        }
    }
    
    
}
