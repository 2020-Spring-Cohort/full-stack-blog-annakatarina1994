package org.wcci.blog;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    @Override
    Optional<Category> findById(Long id);
}
