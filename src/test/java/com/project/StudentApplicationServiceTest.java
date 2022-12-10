package com.project;

import com.project.model.StudentApplication;
import com.project.service.StudentApplicationService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentApplicationServiceTest {

    @Autowired
    private StudentApplicationService studentApplicationService;

    @Test
    void contextLoads() {
    }

    @Test
    public void whenGetAllStudentApplication_thenReturnAllStudentApplication() {
        List<StudentApplication> studentApplication = studentApplicationService.getAll("09456712");
        Assertions.assertThat(studentApplication.size()).isGreaterThan(0);
    }


}
