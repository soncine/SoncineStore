package com.ecommerce.soncineStore.service;

import com.ecommerce.soncineStore.model.Category;

import java.util.List;

public interface categoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);

    String deleteCategory(Long categoryId);
}
