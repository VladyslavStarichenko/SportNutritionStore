package ua.com.alevel.category.service;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.alevel.category.model.Category;

import java.util.*;
import java.util.UUID;

public interface CategoryService  {

    Category createCategory(Category category);

    Category updateCategory(Category category);

    List<Category> getAllCategories();

    Category getCategoryById(UUID id);

    void deleteCategoriesById(UUID id);
}
