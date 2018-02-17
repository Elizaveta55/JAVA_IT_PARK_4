package com.company.app.controllers;

import com.company.app.forms.DiaryForm;
import com.company.app.services.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DiaryController {

    @Autowired
    public DiaryService service;

    @GetMapping("/diary")
    public String getDiary(@ModelAttribute("model") ModelMap model, @RequestParam(value = "error", required = false) String error){
        if (error != null){
            model.addAttribute("error", true);
        }
        return "diary";
    }

    @PostMapping("/diary")
    private String addData(@ModelAttribute("model") ModelMap model, @RequestParam(value = "error", required = false) String error, @ModelAttribute DiaryForm form, Authentication authentication){
        service.addToDB(form, authentication);
        if (error != null){
            model.addAttribute("error", true);
        }
        return "diary";
    }
}
