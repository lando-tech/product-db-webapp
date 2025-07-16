package com.easyrok.db_secure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class SiteSurveyController {

    @GetMapping("/siteSurveyForm")
    public String siteSurveyForm() {
        return "siteSurvey";
    }
}
