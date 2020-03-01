package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

    private CategoryStorage categoryStorage;

    public CategoryController(CategoryStorage categoryStorage) {
        this.categoryStorage = categoryStorage;
    }

    @RequestMapping("/categories")
    public String displayCategories(Model model){
        model.addAttribute("categories", categoryStorage.findAllCategories());
        return "categories";
    }

    @RequestMapping("/categories/{name}")
    public String displaySingleCategory(@PathVariable String name, Model model){
        Category gottenCategory = categoryStorage.findCategoryByName(name);
        model.addAttribute("category", gottenCategory);
        return "category";
    }

    @RequestMapping("/submitpost")
    public String displaySubmittedPost(Model model){
        model.addAttribute("categories", categoryStorage.findAllCategories());
        return "submitpost";

    }

}
