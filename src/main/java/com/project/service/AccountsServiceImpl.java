package com.project.service;

import com.project.model.Accounts;
import com.project.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsServiceImpl implements AccountsService {
    @Autowired
    private AccountsRepository accountsRepository;

    @Override
    public List<Accounts> getAll() {
        return accountsRepository.findAll();
    }

    @Override
    public void add(Accounts accounts) {
        this.accountsRepository.save(accounts);
    }
}