package com.company.app.services;

import com.company.app.dto.UserDto;
import com.company.app.models.User;
import com.company.app.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDto getUserInformation(Authentication authentication) {
        return UserDto.from(usersRepository.findByEmail(authentication.getName()).orElseThrow(IllegalArgumentException::new));
    }
}
