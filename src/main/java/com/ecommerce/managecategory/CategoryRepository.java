package com.ecommerce.managecategory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findById(int categoryId);
}
