package com.project;

import com.project.model.Accounts;
import com.project.service.AccountsService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountsServiceTest {

    @Autowired
    private AccountsService accountsService;

    @Test
    void contextLoads() {
    }

    @Test
    public void whenGetAllAccounts_thenReturnAllAccounts(){
        List<Accounts> accounts = accountsService.getAll();
        Assertions.assertThat(accounts.size()).isGreaterThan(0);
    }

    @Test
    public void getAccountByIdTest(){
        Accounts response =accountsService.getAccountById(6);
        Assertions.assertThat(response.getId()).isEqualTo(6);
    }

    @Test
    public void findAccountPaginatedTest(){
        Page<Accounts> page= accountsService.findAccountPaginated(2,5,"username","asc");
        Assertions.assertThat(page.getSize()).isGreaterThan(0);
    }
}
