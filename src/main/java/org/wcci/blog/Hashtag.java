package org.wcci.blog;

import java.util.Collection;

public class Hashtag {
    private String tag;
    private Long id;
    private Collection<Post> posts;

    public String getTag() {
        return tag;
    }

    public Long getId() {
        return id;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public Hashtag(String tag) {
        this.tag = tag;
    }
}
