package com.dera.sb_ecom.service;

import com.dera.sb_ecom.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
    String deleteCategory(Long categoryId);
    void updateCategory(Category category, Long categoryId);
}
