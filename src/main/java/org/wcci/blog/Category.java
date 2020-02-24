package org.wcci.blog;

import java.util.Collection;
import java.util.Objects;

public class Category {
    private Long id;
    private String categoryName;
    private String categoryDescription;
    private Collection<Post> posts;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(){}

    public Long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryName, category.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName);
    }

    public Collection<Post> getPosts(){
        return posts;
    }
}
