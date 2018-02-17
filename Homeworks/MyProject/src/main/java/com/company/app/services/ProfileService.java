package com.company.app.services;

import com.company.app.dto.UserDto;
import com.company.app.models.User;
import org.springframework.security.core.Authentication;

public interface ProfileService {

    UserDto getUserInformation(Authentication authentication);

}
