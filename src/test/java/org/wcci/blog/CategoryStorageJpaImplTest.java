package org.wcci.blog;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CategoryStorageJpaImplTest {

    @Test
    public void shouldFindAllCategories(){
        CategoryRepository mockCategoryRepo = mock(CategoryRepository.class);
        Category testCategory = new Category("Test Category");
        CategoryStorage underTest = new CategoryStorageJpaImpl(mockCategoryRepo);
        when(mockCategoryRepo.findAll()).thenReturn(Collections.singletonList(testCategory));
        underTest.storeCategory(testCategory);
        verify(mockCategoryRepo).save(testCategory);
        assertThat(underTest.findAllCategories()).contains(testCategory);
    }

    @Test
    public void shouldGetSingleCategoryByName(){
        CategoryRepository mockCategoryRepo = mock(CategoryRepository.class);
        Category testCategory1 = new Category("Test Category");
        Category testCategory2 = new Category("Another Category Name");
        CategoryStorage underTest = new CategoryStorageJpaImpl(mockCategoryRepo);

        underTest.storeCategory(testCategory1);
        underTest.storeCategory(testCategory2);

        Optional<Category> testCategory1Optional = Optional.of(testCategory1);
        when(mockCategoryRepo.findByName("Test Category")).thenReturn(testCategory1Optional);
        Optional<Category> testCategory2Optional = Optional.of(testCategory2);
        when(mockCategoryRepo.findByName("Another Category Name")).thenReturn(testCategory2Optional);

        Category gottenCategory1 = underTest.findCategoryByName("Test Category");
        Category gottenCategory2 = underTest.findCategoryByName("Another Category Name");

        assertThat(gottenCategory1).isEqualTo(testCategory1);
        assertThat(gottenCategory2).isEqualTo(testCategory2);
    }
}
