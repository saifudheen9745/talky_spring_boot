package com.chatapp.talky;

import java.util.List;

public class HttpResponse<T> {

    private String message;
    private Boolean success;
    private List<T> data;

    public HttpResponse(String message, Boolean success, List<T> data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    
    
}
