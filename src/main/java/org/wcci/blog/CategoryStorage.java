package org.wcci.blog;

import java.util.Collection;

public interface CategoryStorage {
    Collection<Category> findAllCategories();

    void storeCategory(Category category);

    Category findCategoryByName(String categoryToFind);
}
