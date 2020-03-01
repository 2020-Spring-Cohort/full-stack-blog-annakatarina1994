package org.wcci.blog;

import java.util.Collection;

public interface PostStorage {
    void storePost(Post postToStore);
    Post findPostById(Long id);

    Collection<Post> findAllPosts();
}
