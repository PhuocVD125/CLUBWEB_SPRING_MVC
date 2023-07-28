package com.phuocvu.web.service;

import com.phuocvu.web.dto.RegistrationDto;
import com.phuocvu.web.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
}
