package org.wcci.blog;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    @Override
    Optional<Author> findById(Long id);
}
