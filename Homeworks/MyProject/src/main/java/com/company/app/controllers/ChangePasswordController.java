package com.company.app.controllers;

import com.company.app.forms.ChangePasswordForm;
import com.company.app.services.ChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class ChangePasswordController {

    @Autowired
    ChangePasswordService changePasswordService;

    @GetMapping("/changePassword")
    public String getChangePasswordPage(@ModelAttribute("model") ModelMap model, @RequestParam(value = "error", required = false) String error)
    {
        if (error != null){
            model.addAttribute("error", true);
        }
        return "changePassword";
    }

    @PostMapping("/changePassword")
    public String doChangePassword(@ModelAttribute("model") ModelMap model, @ModelAttribute ChangePasswordForm form, Authentication authentication){
        boolean check = changePasswordService.updateProfile(authentication, form);
        if (check == false){
            model.addAttribute("error", true);
        }
        return "changePassword";
    }
}
