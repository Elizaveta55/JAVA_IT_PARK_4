package com.company.app.services;

import com.company.app.dto.UserDto;
import com.company.app.forms.ChangeForm;
import com.company.app.forms.ChangePasswordForm;
import org.springframework.security.core.Authentication;

public interface ChangePasswordService {

    UserDto getUserInformation(Authentication authentication);

    boolean updateProfile(Authentication authentication, ChangePasswordForm form);

}
