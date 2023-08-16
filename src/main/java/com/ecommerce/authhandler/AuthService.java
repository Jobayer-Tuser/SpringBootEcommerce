package com.ecommerce.authhandler;

import com.ecommerce.authconfig.JwtService;
import com.ecommerce.enums.Role;
import com.ecommerce.manageuser.User;
import com.ecommerce.manageuser.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private Clock clock;
    public AuthResponse authenticateUser(AuthRequest request) {
        Authentication authenticateUser = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        User user = userRepository.findByEmail(request.email()).orElseThrow();

        if (authenticateUser.isAuthenticated()) {
            return new AuthResponse("success", generateJwtToken(user));
        } else {
            throw new IllegalArgumentException("Not a valid user");
        }
    }

    public AuthResponse registerUser(RegisterRequest request){
        User user = User.builder()
                .fistName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(request.role())
                .createdAt(LocalDateTime.now(clock))
                .build();

        userRepository.save(user);
        return new AuthResponse("success", generateJwtToken(user));
    }

    private String generateJwtToken(User user){
        return jwtService.generateToken(user);
    }
}
