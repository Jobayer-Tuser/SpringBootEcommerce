package com.ecommerce.authhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("authenticate")
    public ResponseEntity<AuthResponse> userAuthentication(@RequestBody AuthRequest request){
        return ResponseEntity.ok(authService.authenticateUser(request));
    }

    @PostMapping("register")
    public ResponseEntity<AuthResponse> userRegistration(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.registerUser(request));
    }
}
