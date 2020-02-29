package org.wcci.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

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
        testPost = new Post("Title", testAuthor, "Arthur", testCategory);
        when(mockStorage.findPostById(5L)).thenReturn(testPost);
    }

    @Test
    public void displayPostReturnsPostTemplate() {
        String result = underTest.displayPost(1L, model);
        assertThat(result).isEqualTo("post");
    }

    @Test
    public void displayPostInteractsWithDependenciesCorrectly() {
        underTest.displayPost(1L, model);
        verify(mockStorage).findPostById(1L);
        verify(model).addAttribute("post", testPost);
    }

    @Test
    public void displayPostMappingIsCorrect() throws Exception{
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/posts/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("post"))
                .andExpect(model().attributeExists("post"))
                .andExpect(model().attribute("post", testPost));
    }

}