package org.wcci.blog;

import java.util.Collection;

public class Author {
    private String name;
    private Collection<Post> posts;

    public String getName() {
        return name;
    }

    public Collection<Post> getPosts() {
        return posts;
    }
}
