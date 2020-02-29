package org.wcci.blog;

import java.util.Collection;

public interface HashtagStorage {
    Collection<Hashtag> findAllHashtags();
    Hashtag findHashtagByName(String hashtagToFind);
    void store(Hashtag hashtagToStore);
}
