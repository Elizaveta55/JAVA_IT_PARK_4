package com.company.app.controllers;

import com.company.app.dto.UserDto;
import com.company.app.forms.ChangeForm;
import com.company.app.services.ChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ChangeController {

    @Autowired
    public ChangeService changeService;


    @GetMapping("/changeNameOrSecondName")
    public String getChangeNameOrSecondNamePage(@ModelAttribute("model") ModelMap model, Authentication authentication) {
        UserDto user = changeService.getUserInformation(authentication);
        model.addAttribute("user", user);
        return "/changeNameOrSecondName";
    }


    @PostMapping("/changeNameOrSecondName")
    public String changeData(@ModelAttribute("model") ModelMap model, @ModelAttribute ChangeForm form, Authentication authentication){
        changeService.updateProfile(authentication, form);
        UserDto user = changeService.getUserInformation(authentication);
        model.addAttribute("user", user);
        return "/profile";
    }

}
