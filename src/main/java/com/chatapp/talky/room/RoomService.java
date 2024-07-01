package com.chatapp.talky.room;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Map<String, String> createRoom(Room roomDetails){
        String roomId = null;
        try {
            Room roomExist = this.roomRepository.findRoomByMembers(roomDetails.getMemberA(), roomDetails.getMemberB());
            if(roomExist == null){
                Room newRoom = this.roomRepository.save(roomDetails);
                roomId = newRoom.getId().toString();
            }else{
                roomId =  roomExist.getId().toString();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("Room creation failed");
        }
        Map<String, String> data = new HashMap<>(); 
        data.put("roomId",roomId);
        return data;
    }
}
