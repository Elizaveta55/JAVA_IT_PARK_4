package com.company.app.controllers;

import com.company.app.models.UserDiary;
import com.company.app.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RatingController {

    @Autowired
    public RatingService ratingService;

    @GetMapping("/ratings")
    public String getRatingPage(@ModelAttribute("model")ModelMap model){
        List<UserDiary> userDiaries = ratingService.getRatingByTest();
        model.addAttribute("users", userDiaries);
        return "ratings";
    }

}
