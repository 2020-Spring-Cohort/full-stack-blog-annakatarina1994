package org.wcci.blog;

import java.util.Collection;

public interface PostStorage {
//    Collection<Post> findAllPosts(Long allPostsToFind);
    void storePost(Post post);
    Post findPostById(Long postToFind);
}
