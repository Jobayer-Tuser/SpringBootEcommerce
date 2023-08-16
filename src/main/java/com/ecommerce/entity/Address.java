package com.ecommerce.entity;

import com.ecommerce.manageuser.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class Address{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String areaName;
    private String zipCode;
    private String city;
    private String state;
    private String mobile;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
}
