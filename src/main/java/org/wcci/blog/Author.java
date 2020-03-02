package org.wcci.blog;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "authors")
    private Collection<Post> posts;

    protected Author(){}

    public String getName() {
        return name;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public Long getId() {
        return id;
    }

    public Author(String name) {
        posts = new ArrayList<>();
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) &&
                Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
