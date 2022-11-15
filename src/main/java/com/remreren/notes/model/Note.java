package com.remreren.notes.model;

import java.util.Date;

public class Note {
    private String title;
    private String content;
    private Date createdAt;
    private Date updatedAt;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdAt = new Date();
        this.updatedAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Note update(String newTitle, String newContent) {
        this.title = newTitle;
        this.content = newContent;
        this.updatedAt = new Date();
        return this;
    }

    @Override
    public String toString() {
        return String.format("\t%s%n\t%s%n", this.title, this.content);
    }
}