package org.wcci.blog;

import java.util.Collection;

public class Author {
    private String name;
    private Long id;
    private Collection<Post> posts;

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
        this.name = name;
    }
}
