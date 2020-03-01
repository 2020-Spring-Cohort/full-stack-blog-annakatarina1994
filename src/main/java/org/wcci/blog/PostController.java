package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

    private PostStorage postStorage;
    private CategoryStorage categoryStorage;
    private HashtagStorage hashtagStorage;
    private AuthorStorage authorStorage;

    public PostController(PostStorage postStorage, HashtagStorage hashtagStorage, CategoryStorage categoryStorage, AuthorStorage authorStorage) {
        this.postStorage = postStorage;
        this.hashtagStorage = hashtagStorage;
        this.categoryStorage = categoryStorage;
        this.authorStorage = authorStorage;
    }

    @RequestMapping("/post/{id}")
    public String displayPost(@PathVariable Long id, Model model){
        Post gottenPost = postStorage.findPostById(id);
        model.addAttribute("post", gottenPost);
        return "post";
    }

    @PostMapping("/submit-post")
    public String submitPost(@RequestParam String title, @RequestParam String authorName, @RequestParam String body, @RequestParam String categoryName){
        Category category = categoryStorage.findCategoryByName(categoryName);
        Author author = authorStorage.findAuthorByName(authorName);
        postStorage.storePost(new Post(title, body, category));
        return "redirect:categories";
    }


}
