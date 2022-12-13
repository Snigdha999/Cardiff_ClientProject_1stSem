package com.project.service;

import com.project.model.Accounts;
import com.project.model.Statistics;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AccountsService  {

    /* Getting all data from the account
     * @return List
     */
    public List<Accounts> getAll();

    /* Adding the data in the account
     * @param Accounts
     */
    public void add(Accounts accounts);

    /* Deleting an account data by their id
     * @param id
     */
    public void deleteAccountById(int id);

    /* Getting an account data by their id
     * @param id
     * @return Accounts
     */
    public Accounts getAccountById(int id);

    Page<Accounts> findAccountPaginated(int accountPageNo, int accountPageSize, String accountSortField, String accountSortDirection);

}
