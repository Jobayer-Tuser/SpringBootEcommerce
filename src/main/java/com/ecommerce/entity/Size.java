package com.ecommerce.entity;

import com.ecommerce.manageproduct.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "size")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(nullable = true)
    private LocalDateTime createdAt;
    @Column(nullable = true)
    private LocalDateTime updatedAt;

}