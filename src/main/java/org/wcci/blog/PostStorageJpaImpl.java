package org.wcci.blog;


import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PostStorageJpaImpl implements PostStorage {

    //need to figure out how to make a findAllPosts() method work

    private PostRepository postRepo;

    public PostStorageJpaImpl(PostRepository postRepo){
        this.postRepo = postRepo;
    }

//    @Override
//    public Collection<Post> findAllPosts(Long id) {
//        return postRepo.findAllPosts();
//    }

    @Override
    public void storePost(Post postToStore) {
        postRepo.save(postToStore);
    }

    @Override
    public Post findPostById(Long id) {
        return postRepo.findById(id).get();
    }
}
