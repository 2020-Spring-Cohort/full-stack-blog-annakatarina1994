package org.wcci.blog;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AuthorStorageJpaImpl implements AuthorStorage {
    private AuthorRepository authorRepo;

    public AuthorStorageJpaImpl(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public void store(Author authorToStore) {
        authorRepo.save(authorToStore);
    }

    @Override
    public Collection<Author> findAllAuthors() {
        return (Collection<Author>) authorRepo.findAll();
    }

    @Override
    public Author findAuthorByName(String name) {
        return authorRepo.findAuthorByName(name).get();
    }
}
