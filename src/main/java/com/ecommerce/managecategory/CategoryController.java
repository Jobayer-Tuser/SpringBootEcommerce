package com.ecommerce.managecategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryInterface categoryInterface;

    @PostMapping("store")
    public void createNewCategory(@RequestBody CategoryRequest request){
        categoryInterface.createNewCategory(request);
    }
}
