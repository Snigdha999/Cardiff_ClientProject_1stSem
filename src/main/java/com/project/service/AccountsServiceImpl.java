package com.project.service;

import com.project.model.Accounts;
import com.project.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountsServiceImpl implements AccountsService {
    @Autowired
    private AccountsRepository accountsRepository;

    /* Getting all data from the account
     * @return List
     */
    @Override
    public List<Accounts> getAll() {
        return accountsRepository.findAll();
    }

    /* Adding the data in the account
     * @param Accounts
     */
    @Override
    public void add(Accounts accounts) {
        this.accountsRepository.save(accounts);
    }

    /* Deleting an account data by their id
     * @param id
     */
    @Override
    public void deleteAccountById(int id) {
        this.accountsRepository.deleteById(id);
    }

    /* Getting an account data by their id
     * @param id
     * @return Accounts
     */
    @Override
    public Accounts getAccountById(int id){
        Optional<Accounts> optional = accountsRepository.findById(id);
        Accounts accounts = null;
        if(optional.isPresent()){
            accounts = optional.get();
        }else{
            throw new RuntimeException("Could not find account with ID: " + id);
        }
        return accounts;
    }

    /* Getting an account data by their page number
     * @param accountPageNo, accountPageSize, accountSortField , accountSortDirection
     * @return List
     */
    @Override
    public Page<Accounts> findAccountPaginated(int accountPageNo, int accountPageSize, String accountSortField, String accountSortDirection) {
        Sort accountSort = accountSortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(accountSortField).ascending() :
                Sort.by(accountSortField).descending();

        Pageable statisticPageable = PageRequest.of(accountPageNo - 1, accountPageSize, accountSort);
        return this.accountsRepository.findAll(statisticPageable);
    }
}
