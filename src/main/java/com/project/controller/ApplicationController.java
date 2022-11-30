package com.project.controller;

import com.project.model.Application;
import com.project.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/applications")
    public String viewApplicationsPage(Model model) {
        model.addAttribute("listApplications", applicationService.getAll());
        return "applications";
    }

    @PostMapping("/addApplication")
    public String addApplication(@ModelAttribute("application") Application application) {
        applicationService.add(application);
        return "redirect:/applications";
    }
}
