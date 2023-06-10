package org.aditya.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Post {

    int id;
    private static AtomicInteger automicIntegerId = new AtomicInteger(0);
    String title;
    String text;
    int createdBy;
    Date createdDate;
    Date updatedDate;

    public Post(String title, String text, int createdBy) {
        this.id = automicIntegerId.incrementAndGet();
        this.title = title;
        this.text = text;
        this.createdBy = createdBy;
        this.createdDate = new Date();
        this.updatedDate = new Date();
    }
}
