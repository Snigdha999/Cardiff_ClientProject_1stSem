package com.project;

import com.project.repository.AccountsRepository;
import com.project.repository.StatisticsRepository;
import com.project.service.AccountsService;
import com.project.service.StatisticsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AccountsServiceTest {

    @Mock
    private AccountsRepository accountsRepository;

    @InjectMocks
    private AccountsService accountsService;

    @Test
    void contextLoads() {
    }
}
