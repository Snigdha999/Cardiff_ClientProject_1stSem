package com.project.controller;

import com.project.model.Accounts;
import com.project.model.StudentApplication;
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

    @GetMapping("/accounts/edit/{id}")
    public String editAccount(@PathVariable (value = "id") int id, Model model){
        Accounts accounts = accountsService.getAccountById(id);
        return "editAccount";
    }

    @PostMapping("/addAccount")
    public String addAccount(@ModelAttribute("newAccount") Accounts accounts) {
        accountsService.add(accounts);
        return "redirect:/accounts";
    }

    @GetMapping("/deleteAccount/{id}")
    public String deleteAccount(@PathVariable (value = "id") int id){
        this.accountsService.deleteAccountById(id);
        return "redirect:/accounts";
    }

    @PostMapping("/accounts/{id}/edit")
    public String editAccounts(@PathVariable (value = "id") int id, @ModelAttribute("newAccount") Accounts accounts){
        accountsService.add(accounts);
        return "redirect:/accounts";
    }

}
