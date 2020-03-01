package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HashtagController {
    private HashtagStorage hashtagStorage;
    private CategoryStorage categoryStorage;
    private PostStorage postStorage;

    public HashtagController(HashtagStorage hashtagStorage, PostStorage postStorage, CategoryStorage categoryStorage){
        this.categoryStorage = categoryStorage;
        this.hashtagStorage = hashtagStorage;
        this.postStorage = postStorage;
    }

    @RequestMapping("/hashtags")
    public String displayHashtags(Model model){
        model.addAttribute("hashtags", hashtagStorage.findAllHashtags());
        return "hashtags";
    }

    @RequestMapping("/hashtag/{name}")
    public String displaySingleHashtag(@PathVariable String name, Model model){
        Hashtag gottenHashtag = hashtagStorage.findHashtagByName(name);
        model.addAttribute("hashtag", gottenHashtag);
        return "hashtag";
    }
}
