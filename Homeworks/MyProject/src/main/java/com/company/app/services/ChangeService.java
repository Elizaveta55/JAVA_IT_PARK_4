package com.company.app.services;

import com.company.app.dto.UserDto;
import com.company.app.forms.ChangeForm;
import com.company.app.models.User;
import org.springframework.security.core.Authentication;

public interface ChangeService{

    UserDto getUserInformation(Authentication authentication);

    void updateProfile(Authentication authentication, ChangeForm form);

}
