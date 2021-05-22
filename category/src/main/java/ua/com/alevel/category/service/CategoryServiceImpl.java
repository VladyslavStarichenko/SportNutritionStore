package ua.com.alevel.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ua.com.alevel.category.exeption.CustomException;
import ua.com.alevel.category.model.Category;
import ua.com.alevel.category.repository.CategoryRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        Optional<Category> categoryDb = this.categoryRepository.findById(category.getId());
        if (categoryDb.isPresent()) {
            Category categoryToUpdate = categoryDb.get();
            categoryToUpdate.setId(category.getId());
            categoryToUpdate.setName(category.getName());
            categoryToUpdate.setDescription(category.getDescription());
            categoryRepository.save(categoryToUpdate);
            return categoryToUpdate;
        } else {
            throw new CustomException("There is no category with id:" + category.getId() + " to update",
                    HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(UUID id) {
        Optional<Category> categoryDb = this.categoryRepository.findById(id);
        if (categoryDb.isPresent()) {
            return categoryDb.get();
        }else{
            throw new CustomException("There is no Category found with request id: " + id,
                    HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteCategoriesById(UUID id) {
        Optional<Category> categoryDb = this.categoryRepository.findById(id);
        if (categoryDb.isPresent()) {
            this.categoryRepository.delete(categoryDb.get());;
        }else{
            throw new CustomException("There is no Category found with request id: " + id,
                    HttpStatus.NOT_FOUND);
        }
    }
}
