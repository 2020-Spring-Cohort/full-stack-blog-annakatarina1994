package org.wcci.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
public class Hashtag {
    private String tag;
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany
    private Collection<Post> posts;

    public Hashtag(){}

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
