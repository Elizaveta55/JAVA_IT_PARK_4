package com.company.app.services;

import com.company.app.forms.PersonalDataForm;
import com.company.app.models.User;
import com.company.app.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class PersonalDataServiceImpl implements PersonalDataService {

    @Autowired
    public UsersRepository usersRepository;

    @Override
    public void addInfo(PersonalDataForm form, Authentication authentication) {
        User user = usersRepository.findByEmail(authentication.getName()).orElseThrow(IllegalArgumentException::new);
        form.addInformation(user);
        usersRepository.save(user);
    }
}
