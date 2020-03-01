package org.wcci.blog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HashtagRepository extends CrudRepository<Hashtag, Long> {
    Optional<Hashtag> findByName(String hashtagToFind);
}
