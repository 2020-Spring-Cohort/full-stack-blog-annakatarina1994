package org.wcci.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaWiringTest {
    @Autowired
        private TestEntityManager entityManager;
    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private HashtagRepository hashtagRepo;
    @Autowired
    private PostRepository postRepo;
    @Autowired
    private AuthorRepository authorRepo;

    @Test
    public void CategoryShouldHaveAListOfPosts(){
        Category testCategory = new Category("TestName");
        Author testAuthor = new Author("Arthur");
        Post testPost = new Post("Post Title", "Post Body", "Arthur", "Test Category", "Speedy");
        Hashtag testTag = new Hashtag("Test Tag");

        categoryRepo.save(testCategory);
        authorRepo.save(testAuthor);
        postRepo.save(testPost);
        hashtagRepo.save(testTag);

        entityManager.flush();
        entityManager.clear();

        Optional<Category> gottenCategoryOptional = categoryRepo.findById(testCategory.getId());
        Category gottenCategory = gottenCategoryOptional.get();
        Post gottenPost = postRepo.findById(testPost.getId()).get();
        assertThat(gottenCategory.getPosts()).contains(testPost);
    }



    }

