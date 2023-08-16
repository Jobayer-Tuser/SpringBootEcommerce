package com.ecommerce.manageuser;

import com.ecommerce.exceptions.UserException;
import org.springframework.stereotype.Service;

@Service
public interface UserInterface {
    User findUserById(Long id) throws UserException;
    User findUserByEmail(String email) throws UserException;
    User findUserProfileByJwt(String jwt) throws UserException;
}
