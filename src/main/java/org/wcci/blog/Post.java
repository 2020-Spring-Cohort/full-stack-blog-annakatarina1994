package org.wcci.blog;

import java.util.Date;

public class Post {
    private String title;
    private String body;
    private String author;
    private String category;
    private String tag;
    private Date date;


    public Post(String title, String body, String author, String category, String tag, Date date) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.category = category;
        this.tag = tag;
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

    public Date getDate() {
        return date;
    }
}