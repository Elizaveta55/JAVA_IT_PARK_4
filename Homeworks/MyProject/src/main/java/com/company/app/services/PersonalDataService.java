package com.company.app.services;

import com.company.app.forms.PersonalDataForm;
import org.springframework.security.core.Authentication;

public interface PersonalDataService {
    void addInfo(PersonalDataForm form, Authentication authentication);
}
