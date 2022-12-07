package com.project.controller;

import com.project.service.StudentApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private StudentApplicationService applicationService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("amountOfApplications", applicationService.getAmountApplications());
        model.addAttribute("amountOfOffers", applicationService.getAmountOfOffers());

        return "homepage";
    }
}