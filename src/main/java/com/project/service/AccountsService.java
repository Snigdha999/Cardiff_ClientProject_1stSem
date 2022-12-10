package com.project.service;

import com.project.model.Accounts;

import java.util.List;

public interface AccountsService {
    List<Accounts> getAll();

    /* Getting all data
     * @return List
     */

    public void deleteAccountById(int id); // Delete an account by their ID
        
    public Accounts getAccountById(int id); // Delete an account by their ID


    /* Adding the data
    * @param Accounts
     */
    public void add(Accounts accounts);
}
