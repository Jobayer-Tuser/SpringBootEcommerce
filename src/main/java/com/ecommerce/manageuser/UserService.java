package com.ecommerce.manageuser;

import com.ecommerce.exceptions.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserInterface{
    @Override
    public User findUserById(Long id) throws UserException {
        return null;
    }

    @Override
    public User findUserByEmail(String email) throws UserException {
        return null;
    }

    @Override
    public User findUserProfileByJwt(String jwt) throws UserException {
        return null;
    }
}
