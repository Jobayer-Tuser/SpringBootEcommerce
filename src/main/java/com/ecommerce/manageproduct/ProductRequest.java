package com.ecommerce.manageproduct;

import com.ecommerce.entity.Size;

import java.util.Set;

public record ProductRequest(String name, String description, double price, double discountPrice, double discountPercent, int quantity, String brand, String color, String imageUrl, Set<Size> size, int categoryId) {
}
