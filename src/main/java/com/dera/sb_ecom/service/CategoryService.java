package com.dera.sb_ecom.service;

import com.dera.sb_ecom.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    String createCategory(Category category);
    String deleteCategory(Long categoryId);
    Category updateCategory(Category category, Long categoryId);
}
