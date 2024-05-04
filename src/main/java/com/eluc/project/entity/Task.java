package com.eluc.project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class Task {
    private int id;
    private String title;
    private String description;
    private String media;
    private String cover;
    private String state;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createdAt;
    private int uid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Timestamp getCreated_At() {
        return createdAt;
    }

    public void setCreated_At(Timestamp created_At) {
        this.createdAt = created_At;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", media='" + media + '\'' +
                ", cover='" + cover + '\'' +
                ", state='" + state + '\'' +
                ", created_At=" + createdAt +
                ", uid=" + uid +
                '}';
    }
}
