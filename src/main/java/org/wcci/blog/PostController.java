package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PostController {

    private PostStorage postStorage;
    private CategoryStorage categoryStorage;
    private HashtagStorage hashtagStorage;
    private AuthorStorage authorStorage;
    private HashtagRepository hashtagRepo;
    private AuthorRepository authorRepo;

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

    @PostMapping("/post/{id}/add-hashtag")
    public String addHashtagToPost(@RequestParam String name, @PathVariable Long id){
        Hashtag hashtagToAddToPost;
        Optional<Hashtag> hashtagOptional = hashtagRepo.findByName(name);
        if(hashtagOptional.isEmpty()){
            hashtagToAddToPost = new Hashtag(name);
            hashtagRepo.save(hashtagToAddToPost);
        }else{
            hashtagToAddToPost = hashtagOptional.get();
        }
        Post postToAddHashtagTo = postStorage.findPostById(id);
        postToAddHashtagTo.addHashtag(hashtagToAddToPost);
        postStorage.storePost(postToAddHashtagTo);
        return "redirect:categories";
    }

    @PostMapping("/post/{id}/add-author")
    public String addAuthorToPost(@RequestParam String name, @PathVariable Long id){
        Author authorToAddToPost;
        Optional<Author> authorOptional = authorRepo.findByName(name);
        if(authorOptional.isEmpty()){
            authorToAddToPost = new Author(name);
            authorRepo.save(authorToAddToPost);
        }else{
            authorToAddToPost = authorOptional.get();
        }
        Post postToAddAuthorTo = postStorage.findPostById(id);
        postToAddAuthorTo.addAuthor(authorToAddToPost);
        postStorage.storePost(postToAddAuthorTo);
        return "redirect:categories";
    }

}
