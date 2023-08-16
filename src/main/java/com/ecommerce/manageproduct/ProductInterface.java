package com.ecommerce.manageproduct;

import com.ecommerce.entity.Size;
import org.springframework.data.domain.Page;

import java.awt.*;
import java.util.List;

public interface ProductInterface {
    Product createNewProduct(ProductRequest request);
    Product updateExistingProduct(ProductRequest request, Long id);
    Product findProductById(Long id);
    List<Product> findProductsByCategory(String category);
    String deleteProduct(Long id);
    Page<Product> findAllProducts(String category, List<Color> colors, List<Size> sizes, double minPrice, double maxPrice, double minDiscount, String sort, String stock, int pageNumber, int pageSize);
}
