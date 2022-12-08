package com.project;

import com.project.repository.StatisticsRepository;
import com.project.repository.StudentApplicationRepository;
import com.project.service.StatisticsService;
import com.project.service.StudentApplicationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StudentApplicationServiceTest {

    @Mock
    private StudentApplicationRepository studentApplicationRepository;

    @InjectMocks
    private StudentApplicationService studentApplicationService;

    @Test
    void contextLoads() {
    }


}
