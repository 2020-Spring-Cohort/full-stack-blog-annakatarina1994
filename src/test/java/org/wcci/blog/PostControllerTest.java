package org.wcci.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PostControllerTest {

    private PostController underTest;
    private Model model;
    private PostStorage mockStorage;
    private Post testPost;
    private HashtagRepository hashtagRepo;

    @BeforeEach
    void setUp(){
        mockStorage = mock(PostStorage.class);
        underTest = new PostController(mockStorage, hashtagRepo);
        model = mock(Model.class);

        Category testCategory = new Category("coupe");
        Author testAuthor = new Author("Arthur");
        testPost = new Post("Title", "Body", "Arthur", "coupe", "smol");
        when(mockStorage.findPostById(5L)).thenReturn(testPost);
    }

    @Test
    public void displayPostReturnsPostTemplate() {
        String result = underTest.displayPost(1L, model);
        assertThat(result).isEqualTo("post");
    }

    @Test


}