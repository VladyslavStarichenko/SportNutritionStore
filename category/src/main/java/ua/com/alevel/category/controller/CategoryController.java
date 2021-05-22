package ua.com.alevel.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.category.model.Category;
import ua.com.alevel.category.service.CategoryService;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/categories")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    ResponseEntity<List<Category>> getAllCategories(){
        return ResponseEntity.ok().body(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    ResponseEntity<Category> getCategoryById(@PathVariable UUID id){
        return ResponseEntity.ok().body(categoryService.getCategoryById(id));
    }


    @PostMapping()
    public  ResponseEntity<Category> createCategory(@RequestBody Category category ){
        return  ResponseEntity.ok().body(this.categoryService.createCategory(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable UUID id, @RequestBody Category category){
        category.setId(id);
        return  ResponseEntity.ok().body(this.categoryService.updateCategory(category));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteCategory(@PathVariable UUID id){
        this.categoryService.deleteCategoriesById(id);
        return HttpStatus.OK;
    }
}
