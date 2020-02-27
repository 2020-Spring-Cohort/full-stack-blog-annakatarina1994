package org.wcci.blog;


import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PostStorageJpaImpl implements PostStorage {

    private PostRepository postRepo;

    public PostStorageJpaImpl(PostRepository postRepo){
        this.postRepo = postRepo;
    }

    @Override
    public Collection<Post> findAllPosts() {
        return null;
    }

    @Override
    public void storePost(Post postToStore) {
    }

    @Override
    public Post findPostById(Long id) {
        return postRepo.findById(id).get();
    }
}
