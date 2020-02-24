package org.wcci.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;


public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String body;
    private String author;
    private String category;
    private String tag;
    private LocalDateTime date;

    public Post(String title, String body, String author, String category, String tag, Long id, LocalDateTime date) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.category = category;
        this.tag = tag;
        this.id = id;
        this.date = date;

    }
    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getTag() {
        return tag;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }
}