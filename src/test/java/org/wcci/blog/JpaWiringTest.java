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
    public void CategoryShouldHaveAListOfPosts() {
        Category testCategory = new Category("testCategory");
        Author testAuthor = new Author("test name");
        Post testPost = new Post("Title", "Body", testCategory);

        categoryRepo.save(testCategory);
        postRepo.save(testPost);
        authorRepo.save(testAuthor);

        entityManager.flush();
        entityManager.clear();

        Optional<Category> gottenCategoryOptional = categoryRepo.findById(testCategory.getId());
        Category gottenCategory = gottenCategoryOptional.get();
        Post gottenPost = postRepo.findById(testPost.getId()).get();
        assertThat(gottenCategory.getPosts()).contains(testPost);
    }

    @Test
    public void postShouldBeAbleToHaveMultipleHashtags() {
        Category testCategory1 = categoryRepo.save(new Category("Test Category"));
        Post testPost1 = postRepo.save(new Post("Title", "body", testCategory1));
        Hashtag testHashtag1 = hashtagRepo.save(new Hashtag("Speedy"));
        Hashtag testHashtag2 = hashtagRepo.save(new Hashtag("smol"));
        Hashtag testHashtag3 = hashtagRepo.save(new Hashtag("metal"));

        testPost1.addHashtag(testHashtag1);
        testPost1.addHashtag(testHashtag2);
        testPost1.addHashtag(testHashtag3);
        postRepo.save(testPost1);

        entityManager.flush();
        entityManager.clear();

        Post gottenPost1 = postRepo.findById(testPost1.getId()).get();

        assertThat(gottenPost1.getTags()).contains(testHashtag1, testHashtag2, testHashtag3);
    }

//    @Test
//        public void authorShouldBeAbleToBeAddedToPost() {
//        Category testCategory2 = categoryRepo.save(new Category("Category"));
//        Author testAuthor1 = authorRepo.save(new Author("Arthur"));
//        Post testPost2 = postRepo.save(new Post("Title", "Body", testCategory2));
//        testPost2.addAuthor(testAuthor1);
//        postRepo.save(testPost2);
//
//        entityManager.flush();
//        entityManager.clear();
//
//        Post gottenPost2 = postRepo.findById(testPost2.getId()).get();
//        assertThat(gottenPost2.getAuthor()).contains(testAuthor1);
//    }
}

