package org.wcci.blog;

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
    private String categoryName;
    private String tag;
//    private LocalDateTime date;

    public Post(String title, String body, String author, String categoryName, String tag) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.categoryName = categoryName;
        this.tag = tag;
//        this.date = LocalDateTime.now();
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

    public String getCategoryName() {
        return categoryName;
    }

    public String getTag() {
        return tag;
    }

    public Long getId() {
        return id;
    }

//    public LocalDateTime getDate() {
//        return date;
//    }
}