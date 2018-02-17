package com.company.app.services;

import com.company.app.forms.DiaryForm;
import com.company.app.models.UserDiary;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface DiaryService {

    void addToDB(DiaryForm form, Authentication authentication);
    void delete();
    List<UserDiary> findAll (Authentication authentication);

}
