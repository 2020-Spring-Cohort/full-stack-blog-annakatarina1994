package org.wcci.blog;

import java.util.Collection;

public interface HashtagStorage {
    Collection<Hashtag> findAllHashtags();
    void storeHashtag(Hashtag hashtag);
    Hashtag findHashtagByName(String hashtagToFind);
}
