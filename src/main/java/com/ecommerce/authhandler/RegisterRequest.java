package com.ecommerce.authhandler;

import com.ecommerce.enums.Role;

public record RegisterRequest(String firstName, String lastName, String email, String password, Role role) {
}
