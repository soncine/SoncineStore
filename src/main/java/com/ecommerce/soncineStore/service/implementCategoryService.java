package com.ecommerce.soncineStore.service;

import com.ecommerce.soncineStore.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class implementCategoryService implements categoryService {

    private List<Category> categories = new ArrayList<>();
    private Long nextID = 1L;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextID++);
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categories.stream()
                .filter(c -> c.getCategoryId() == (categoryId))
                .findFirst().orElse(null);
        if(category == null)
            return "Category not found :(";
        categories.remove(category);
        return "Category with Id: " + categoryId + " deleted successfully!";
    }
}
