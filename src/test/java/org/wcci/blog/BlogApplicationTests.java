package org.wcci.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BlogApplicationTests {

    @MockBean
    PostStorage postStorage;
    @MockBean
    AuthorStorage authorStorage;
    @MockBean
    CategoryStorage categoryStorage;
    @MockBean
    HashtagStorage hashtagStorage;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReceiveOKFromCampusesEndPoint() throws Exception{
        mockMvc.perform(get("/categories"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReceiveOKFromSingleCampusEndpoint() throws Exception {
        Category testCategory = new Category("Test Category");
        when(categoryStorage.findCategoryByName("Test Category")).thenReturn(testCategory);
        mockMvc.perform(get("/categories/Test Category"))
                .andExpect(status().isOk());
    }
}
