package org.wcci.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Hashtag {
    private String name;
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany(mappedBy = "tags")
    private Collection<Post> posts;

    public Hashtag(){}

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public Hashtag(String name) {
        posts = new ArrayList<>();
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hashtag hashtag = (Hashtag) o;
        return Objects.equals(name, hashtag.name) &&
                Objects.equals(id, hashtag.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
