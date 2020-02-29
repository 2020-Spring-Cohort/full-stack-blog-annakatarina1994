package org.wcci.blog;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String body;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Category category;
    @ManyToMany
    private Collection<Hashtag> tags;
    private LocalDateTime date;

    public Post(){}

    public Post(String title, Author author, String body, Category category) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.category = category;
        this.tags = new HashSet<>();
        this.date = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    public Collection<Hashtag> getTags() {
        return tags;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) &&
                Objects.equals(title, post.title) &&
                Objects.equals(body, post.body) &&
                Objects.equals(author, post.author) &&
                Objects.equals(category, post.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, author, category);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", author=" + author +
                ", category=" + category +
                '}';
    }

    public void addHashtag(Hashtag hashtagToAdd) {
        tags.add(hashtagToAdd);
    }
}