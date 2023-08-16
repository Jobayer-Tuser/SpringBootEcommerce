package com.ecommerce.managecategory;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CategoryService implements CategoryInterface {

    private CategoryRepository categoryRepository;

    @Override
    public void createNewCategory(CategoryRequest request) {

/*        if (request.parentCategoryId() == null){

        }*/

        Category category = Category.builder()
                .name(request.name())
                .createdAt(LocalDateTime.now())
                .build();
        categoryRepository.save(category);
    }
}
