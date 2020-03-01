package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorStorage authorStorage;
    private PostStorage postStorage;

    public AuthorController(AuthorStorage authorStorage, PostStorage postStorage){
        this.authorStorage = authorStorage;
        this.postStorage = postStorage;
    }

    @RequestMapping("/authors")
    public String displayAuthors(Model model){
        model.addAttribute("authors", authorStorage.findAllAuthors());
        return "authors";
    }

    @RequestMapping("/authors/{name}")
    public String displaySingleAuthor(@PathVariable String name, Model model){
        Author gottenAuthor = authorStorage.findAuthorByName(name);
        model.addAttribute("author", gottenAuthor);
        return "author";
    }
}
