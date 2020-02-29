package org.wcci.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PostStorageJpaImplTest {
    private PostRepository postRepo;
    private PostStorage underTest;
    private Post testPost;

    @BeforeEach
    void setUp() {
        postRepo = mock(PostRepository.class);
        underTest = new PostStorageJpaImpl(postRepo);
        Category testCategory = new Category("Test Category");
        Author testAuthor = new Author("Arthur");
        testPost = new Post("Title", testAuthor, "Body", testCategory);
    }

    @Test
    public void shouldFindPostById() {
        when(postRepo.findById(1L)).thenReturn(Optional.of(testPost));
        Post gottenPost = underTest.findPostById(1L);
        assertThat(gottenPost).isEqualTo(testPost);
    }

    @Test
    public void shouldStorePost(){
        underTest.storePost(testPost);
        verify(postRepo).save(testPost);
    }
}

