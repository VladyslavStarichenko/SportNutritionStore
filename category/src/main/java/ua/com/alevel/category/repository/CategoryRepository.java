package ua.com.alevel.category.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.alevel.category.model.Category;

import java.util.UUID;


@Repository
public interface CategoryRepository  extends JpaRepository<Category, UUID> {

}
