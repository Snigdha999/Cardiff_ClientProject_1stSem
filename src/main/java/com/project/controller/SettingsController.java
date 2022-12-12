package com.project.controller;

import com.project.model.Accounts;
import com.project.model.Statistics;
import com.project.model.StudentApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.project.service.AccountsService;

import java.util.List;

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

        return findAccountPaginated(1, "username", "asc", model);
    }

    @GetMapping("/editAccount/{id}")
    public String editAccount(@PathVariable (value = "id") int id, Model model){
        Accounts accounts = accountsService.getAccountById(id);
        model.addAttribute("updateAccount", accounts);
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

    @PostMapping("/editAccount/{id}")
    public String editAccounts(@PathVariable (value = "id") int id, @ModelAttribute("newAccount") Accounts accounts){
        accountsService.add(accounts);
        return "redirect:/accounts";
    }

    @GetMapping("/accountPage/{accountPageNo}")
    public String findAccountPaginated(@PathVariable (value = "accountPageNo") int accountPageNo,
                                         @RequestParam("accountSortField") String accountSortField,
                                         @RequestParam("accountSortDir") String accountSortDir,
                                         Model model){
        int accountPageSize = 4;

        Page<Accounts> accountPage = accountsService.findAccountPaginated(accountPageNo, accountPageSize, accountSortField, accountSortDir);
        List<Accounts> accounts = accountPage.getContent();

        model.addAttribute("currentAccountPage", accountPageNo);
        model.addAttribute("accountTotalPages", accountPage.getTotalPages());
        model.addAttribute("accountTotalItems", accountPage.getTotalElements());

        model.addAttribute("accountSortField",accountSortField);
        model.addAttribute("accountSortDir",accountSortDir);
        model.addAttribute("reverseAccountSortDir", accountSortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listAccounts", accounts);


        return "accounts";

    }

}
