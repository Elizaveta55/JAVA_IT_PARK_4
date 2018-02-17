package com.company.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EntranceController {

    @GetMapping("/entrance")
    private String getEntrancePage(){
        return "entrance";
    }
}
