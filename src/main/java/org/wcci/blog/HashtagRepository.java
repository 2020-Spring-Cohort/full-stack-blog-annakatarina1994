package org.wcci.blog;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface HashtagRepository extends CrudRepository<Hashtag, Long> {
    @Override
    Optional<Hashtag> findById(Long id);

    Optional<Hashtag> findByName(String hashtagToFind);
}
