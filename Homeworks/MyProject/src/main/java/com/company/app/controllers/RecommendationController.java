package com.company.app.controllers;

import com.company.app.services.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalTime;
import java.util.List;

@Controller
public class RecommendationController {

    @Autowired
    public RecommendationService service;

    @GetMapping("/recommendation")
    public String getRecommendationPage(@ModelAttribute("model")ModelMap model, Authentication authentication){
        List<LocalTime> times = service.getRecommendation(authentication);
        model.addAttribute("times", times);
        return "recommendation";
    }

}
