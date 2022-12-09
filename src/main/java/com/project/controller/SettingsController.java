package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.project.service.AccountsService;

@Controller
public class SettingsController {
    @Autowired
    private AccountsService accountsService;

    @GetMapping("/settings")
    public String viewSettingsPage(Model model) {
        return "settings";
    }

    @GetMapping("/accounts")
    public String viewAccountsPage(Model model) {
        model.addAttribute("listAccounts", accountsService.getAll());
        return "accounts";
    }

}
