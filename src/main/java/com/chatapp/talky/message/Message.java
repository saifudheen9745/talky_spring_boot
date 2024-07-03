package com.chatapp.talky.message;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Message {

    @Id
    @SequenceGenerator(
        initialValue=1,
        allocationSize=1,
        name="message_id_sequence",
        sequenceName="message_id_sequence"
    )
    @GeneratedValue(
        strategy=GenerationType.SEQUENCE,
        generator="message_id_sequence"
    )
    private Long id;
    private Long date;
    private String msgFrom;
    private String msgTo;
    private String message;
    private String room;

    public Message() {
    }

    public Message(Long date, String msgFrom, Long id, String message, String room, String msgTo) {
        this.date = date;
        this.msgFrom = msgFrom;
        this.id = id;
        this.message = message;
        this.room = room;
        this.msgTo = msgTo;
    }

    public Message(Long date, String msgFrom, String message, String room, String msgTo) {
        this.date = date;
        this.msgFrom = msgFrom;
        this.message = message;
        this.room = room;
        this.msgTo = msgTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getmsgFrom() {
        return msgFrom;
    }

    public void setmsgFrom(String msgFrom) {
        this.msgFrom = msgFrom;
    }

    public String getmsgTo() {
        return msgTo;
    }

    public void setmsgTo(String msgTo) {
        this.msgTo = msgTo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }



}
