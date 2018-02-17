package com.company.app.controllers;

import com.company.app.dto.UserDto;
import com.company.app.models.User;
import com.company.app.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    @Autowired
    public ProfileService profileService;

    @GetMapping("/profile")
    public String getProfilePage(@ModelAttribute("model")ModelMap model, Authentication authentication){
        UserDto user = profileService.getUserInformation(authentication);
        if (user.getName() == null){
            return "personalData";
        }
        model.addAttribute("user", user);
        return "profilePage";
    }

    @PostMapping("/profile")
    public String checkPostMethod(@ModelAttribute("model")ModelMap model, Authentication authentication){
        UserDto user = profileService.getUserInformation(authentication);
        model.addAttribute("user", user);
        return "profilePage";
    }

}
