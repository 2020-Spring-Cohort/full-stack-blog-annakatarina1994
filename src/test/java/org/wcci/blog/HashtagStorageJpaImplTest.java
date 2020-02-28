package org.wcci.blog;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HashtagStorageJpaImplTest {
    @Test
    public void shouldStoreHashtag(){
        HashtagRepository hashtagRepo = mock(HashtagRepository.class);
        HashtagStorage underTest = new HashtagStorageJpaImpl(hashtagRepo);
        Hashtag testTag = new Hashtag("Tag");
        underTest.store(testTag);
        verify(hashtagRepo).save(testTag);
    }
}
