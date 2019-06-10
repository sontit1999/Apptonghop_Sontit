package com.example.sonnewspaper;

public class Chatmessage {
    String usersend;
    String content;
    String time;

    public Chatmessage(String usersend, String content, String time) {
        this.usersend = usersend;
        this.content = content;
        this.time = time;
    }

    public String getUsersend() {
        return usersend;
    }

    public void setUsersend(String usersend) {
        this.usersend = usersend;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
