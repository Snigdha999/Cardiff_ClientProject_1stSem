package com.project.service;

import com.project.model.Accounts;

import java.util.List;

public interface AccountsService {

    /* Getting all data
     * @return List
     */
    public List<Accounts> getAll();

    /* Adding the data
     * @param Accounts
     */
    public void add(Accounts accounts);
}
