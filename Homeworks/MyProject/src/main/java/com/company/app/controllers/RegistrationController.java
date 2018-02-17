package com.company.app.controllers;

import com.company.app.forms.RegistrationForm;
import com.company.app.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @Autowired
    public RegistrationService service;

    @GetMapping("/signIn")
    public String getSignInPage(@ModelAttribute("model") ModelMap model, @RequestParam(value = "error", required = false) String error) {
        if (error != null) {
            model.addAttribute("error", true);
        }
        return "signIn";
    }

    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "signUp";
    }

    @PostMapping("/signUp")
    public String registrationUser (@ModelAttribute RegistrationForm form){
        boolean checkError = service.registrationUser(form);
        if (checkError == true) return "successSignUp";
        else return "notSuccessSignUp";
    }

    @GetMapping("/confirm/{confirm-string}")
    public String getConfirmPage(@PathVariable("confirm-string") String confirmString,
                                 @ModelAttribute("model") ModelMap model) {
        boolean confirmResult = service.confirmUser(confirmString);
        model.addAttribute("confirmResult", confirmResult);
        return "confirmResult";
    }
}
