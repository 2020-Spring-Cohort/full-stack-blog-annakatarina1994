package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


public class PostController {
    private PostStorage postStorage;

    public PostController(PostStorage postStorage, HashtagRepository hashtagRepo) {
        this.postStorage = postStorage;
    }

    public String displayPost(Long id, Model model) {

    }
}
