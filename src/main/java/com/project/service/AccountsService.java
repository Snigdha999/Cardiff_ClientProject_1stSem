package com.project.service;

import com.project.model.Accounts;

import java.util.List;

public interface AccountsService {
    List<Accounts> getAll();

    void add(Accounts accounts);
}
