package org.wcci.blog;

import org.springframework.stereotype.Controller;


public class CategoryController {
    private CategoryStorage categoryStorage;

    public CategoryController(CategoryStorage categoryStorage) {
        this.categoryStorage = categoryStorage;
    }


}
