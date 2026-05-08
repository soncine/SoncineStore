package com.ecommerce.soncineStore.controller;


import com.ecommerce.soncineStore.model.Category;
import com.ecommerce.soncineStore.service.categoryService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    //Aqui é onde ficam os mapas

    private categoryService categoryService;

    public CategoryController(categoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return "category added sucessfully!";
    }

    @DeleteMapping("/api/admin/categories/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId){
        String status = categoryService.deleteCategory(categoryId);
        return status;
    }
}
