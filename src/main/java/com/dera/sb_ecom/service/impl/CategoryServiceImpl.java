package com.dera.sb_ecom.service.impl;

import com.dera.sb_ecom.category.CategoryRepository;
import com.dera.sb_ecom.model.Category;
import com.dera.sb_ecom.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
       return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryName(category.getCategoryName());
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
        return "category with id " + categoryId + " has been deleted";
    }

    @Override
    public void updateCategory(Category category, Long categoryId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isPresent()) {
            Category categoryToUpdate = categoryOptional.get();
            categoryToUpdate.setCategoryName(category.getCategoryName());
            categoryRepository.save(categoryToUpdate);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with id " + categoryId + " does not exist");
        }
    }
}
