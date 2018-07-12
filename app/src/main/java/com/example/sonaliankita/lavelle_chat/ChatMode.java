package com.example.sonaliankita.lavelle_chat;

/**
 * Created by Sonali Ankita on 11-07-2018.
 */

public class ChatMode {
    public String message;
    public boolean isSend;

    public ChatMode(String message, boolean isSend) {
        this.message = message;
        this.isSend = isSend;
    }

    public ChatMode() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }
}
