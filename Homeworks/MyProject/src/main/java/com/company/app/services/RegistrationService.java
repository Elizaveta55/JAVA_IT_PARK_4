package com.company.app.services;

import com.company.app.forms.RegistrationForm;

public interface RegistrationService {

    boolean registrationUser(RegistrationForm form);
    boolean confirmUser(String confirmString);
}
