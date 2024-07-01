package com.chatapp.talky.room;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.chatapp.talky.HttpResponse;


@RestController
@RequestMapping(path="/api/v1/user/room", produces=MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins="http://localhost:4300")
public class RoomContoller {

    @Autowired
    private RoomService roomService;

    @SuppressWarnings("rawtypes")
    @PostMapping()
    public ResponseEntity<HttpResponse> createRoom(@RequestBody Room roomDetails) {
        try {
            System.out.println(roomDetails);
            Map<String, String> roomId = this.roomService.createRoom(roomDetails);
        if(!roomId.get("roomId").isBlank()){
            return new ResponseEntity<>(new HttpResponse<>("Room created successfully", true, List.of(roomId)), HttpStatus.CREATED);
        } else {
            throw new IllegalArgumentException("Room creation failed");
        }
        
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new HttpResponse<>(e.getMessage(), true, List.of()), HttpStatus.BAD_REQUEST);
        }
    }
    

}
