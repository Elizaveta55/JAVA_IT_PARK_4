package com.company.app.services;

import com.company.app.dto.UserDto;
import com.company.app.forms.ChangeForm;
import com.company.app.forms.ChangePasswordForm;
import com.company.app.models.User;
import com.company.app.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordServiceImpl implements ChangePasswordService {

    @Autowired
    public UsersRepository usersRepository;

    @Override
    public UserDto getUserInformation(Authentication authentication) {
        return UserDto.from(usersRepository.findByEmail(authentication.getName())
                .orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public boolean updateProfile(Authentication authentication, ChangePasswordForm form) {
        User user = usersRepository.findByEmail(authentication.getName()).orElseThrow(IllegalArgumentException::new);
        boolean check = form.changePassword(user);
        if (check==true) {
            usersRepository.save(user);
            return true;
        }
        else {
            return false;
        }
    }
}
