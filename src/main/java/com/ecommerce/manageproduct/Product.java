package com.ecommerce.manageproduct;

import com.ecommerce.managecategory.Category;
import com.ecommerce.entity.Rating;
import com.ecommerce.entity.Review;
import com.ecommerce.entity.Size;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private double discountedPrice;
    private double discountedPercent;
    private int quantity;
    private String brand;
    private String color;
    private String imageUrl;
    private int numberOfRatings;

    @OneToMany(mappedBy = "product")
    private Set<Size> sizes = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rating> ratings = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @ManyToOne
    private Category category;

    @Column(nullable = true)
    private LocalDateTime createdAt;
    @Column(nullable = true)
    private LocalDateTime updatedAt;

}