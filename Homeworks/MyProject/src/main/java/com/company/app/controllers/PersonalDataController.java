package com.company.app.controllers;

import com.company.app.forms.PersonalDataForm;
import com.company.app.services.PersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonalDataController {

    @Autowired
    PersonalDataService personalDataService;

    @GetMapping("/personalData")
    public String getPersonalDataPage(){
        return "personalData";
    }

    @PostMapping("/personalData")
    public String addPersonalDataInfo(@ModelAttribute PersonalDataForm form, Authentication authentication){
        personalDataService.addInfo(form, authentication);
        return "profile";
    }

}
