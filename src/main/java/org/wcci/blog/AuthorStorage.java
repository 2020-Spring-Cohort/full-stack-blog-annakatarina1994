package org.wcci.blog;

import java.util.Collection;

public interface AuthorStorage {

    void store(Author authorToStore);

    Collection<Author> findAllAuthors();

    Author findAuthorByName(String name);
}
