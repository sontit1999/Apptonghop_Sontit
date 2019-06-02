package com.example.sonnewspaper;

public class NewPost {
    String image;
    String tittle;
    String time;
    String linkbaiviet;

    public NewPost(String image, String tittle, String time, String linkbaiviet) {
        this.image = image;
        this.tittle = tittle;
        this.time = time;
        this.linkbaiviet = linkbaiviet;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLinkbaiviet() {
        return linkbaiviet;
    }

    public void setLinkbaiviet(String linkbaiviet) {
        this.linkbaiviet = linkbaiviet;
    }
}
