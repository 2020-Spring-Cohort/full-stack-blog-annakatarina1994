package org.wcci.blog;

import org.springframework.stereotype.Service;

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
}
