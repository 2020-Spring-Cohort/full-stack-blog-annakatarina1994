package org.wcci.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Author {
    private String name;
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany
    private Collection<Post> posts;

    public Author(){}

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
