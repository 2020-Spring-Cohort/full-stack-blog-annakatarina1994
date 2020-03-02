package org.wcci.blog;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class HashtagStorageJpaImpl implements HashtagStorage {
    private HashtagRepository hashtagRepo;

    public HashtagStorageJpaImpl(HashtagRepository hashtagRepo) {
        this.hashtagRepo = hashtagRepo;
    }

    @Override
    public void store(Hashtag hashtagToStore) {
        hashtagRepo.save(hashtagToStore);
    }

    @Override
    public Collection<Hashtag> findAllHashtags() {
        return (Collection<Hashtag>) hashtagRepo.findAll();
    }

    @Override
    public Hashtag findHashtagByName(String hashtagToFind) {
        return hashtagRepo.findByName(hashtagToFind).get();
    }
}
