package com.chatapp.talky.message;

public class Message {

    private Long id;
    private Long date;
    private String from;
    private String to;
    private String message;
    private String room;

    public Message() {
    }

    public Message(Long date, String from, Long id, String message, String room, String to) {
        this.date = date;
        this.from = from;
        this.id = id;
        this.message = message;
        this.room = room;
        this.to = to;
    }

    public Message(Long date, String from, String message, String room, String to) {
        this.date = date;
        this.from = from;
        this.message = message;
        this.room = room;
        this.to = to;
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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
