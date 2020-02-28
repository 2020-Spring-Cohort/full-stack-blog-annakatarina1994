package org.wcci.blog;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CategoryStorageJpaImpl implements CategoryStorage {
    private CategoryRepository categoryRepo;

    public CategoryStorageJpaImpl(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Collection<Category> findAllCategories() {
        return (Collection<Category>) categoryRepo.findAll();
    }

    @Override
    public void storeCategory(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public Category findCategoryByName(String categoryName) {
        return categoryRepo.findByCategoryName(categoryName).get();
    }
}
