package com.ecommerce.manageproduct;

import com.ecommerce.entity.Size;
import com.ecommerce.managecategory.Category;
import com.ecommerce.managecategory.CategoryRepository;
import com.ecommerce.manageuser.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductInterface{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private UserService userService;

    @Override
    public Product createNewProduct(ProductRequest request) {
        Category category = categoryRepository.findById(request.categoryId());

        Product product = Product.builder()
                .name(request.name())
                .description(request.description())
                .category(category)
                .price(request.price())
                .discountedPrice(request.discountPrice())
                .discountedPercent(request.discountPercent())
                .quantity(request.quantity())
                .brand(request.brand())
                .color(request.color())
                .sizes(request.size())
                .imageUrl(request.imageUrl())
                .createdAt(LocalDateTime.now())
                .build();
        Product product1 = productRepository.save(product);
        return product1;
    }

    @Override
    public Product updateExistingProduct(ProductRequest request, Long id) {
        return null;
    }

    @Override
    public Product findProductById(Long id) {
        return null;
    }

    @Override
    public List<Product> findProductsByCategory(String category) {
        return null;
    }

    @Override
    public String deleteProduct(Long id) {
        return null;
    }

    @Override
    public Page<Product> findAllProducts(String category, List<Color> colors, List<Size> sizes, double minPrice, double maxPrice, double minDiscount, String sort, String stock, int pageNumber, int pageSize) {
        return null;
    }
}
