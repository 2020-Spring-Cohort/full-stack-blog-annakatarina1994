package org.wcci.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

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
        
    }
    }

