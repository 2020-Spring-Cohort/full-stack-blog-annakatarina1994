package org.wcci.blog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HashtagRepository extends CrudRepository<Hashtag, String> {
    Optional<Hashtag> findByName(String hashtagToFind);
}
