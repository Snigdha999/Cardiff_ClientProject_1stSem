package com.project;

import com.project.model.Accounts;
import com.project.repository.AccountsRepository;
import com.project.repository.StatisticsRepository;
import com.project.service.AccountsService;
import com.project.service.StatisticsService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
}
