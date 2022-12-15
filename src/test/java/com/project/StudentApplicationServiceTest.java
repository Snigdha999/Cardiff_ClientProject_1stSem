package com.project;

import com.project.model.StudentApplication;
import com.project.service.StudentApplicationService;
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
public class StudentApplicationServiceTest {

    @Autowired
    private StudentApplicationService studentApplicationService;



    @Test
    public void whenGetAllStudentApplication_thenReturnAllStudentApplication() {
        List<StudentApplication> studentApplication = studentApplicationService.getAll("09456712");
        Assertions.assertThat(studentApplication.size()).isGreaterThan(0);
    }

    @Test
    public void whenDeleteAllStudentApplication_thenReturnNoStudentApplication() {
        List<StudentApplication> studentApplication = studentApplicationService.getAll("09456712");
        studentApplicationService.deleteAll();;
        Assertions.assertThat(studentApplication.size()).isEqualTo(0);
    }


    @Test
    public void testGetAmountOfOffers(){
       int response= studentApplicationService.getAmountOfOffers();
        Assertions.assertThat(response).isEqualTo(0);
    }
    @Test
    public void testFindApplicationPaginated(){
        Page<StudentApplication> page= studentApplicationService.findApplicationPaginated(2,5,"ucasCode","asc");
        Assertions.assertThat(page.getSize()).isEqualTo(5);

    }

    @Test
    public void deleteStudentApplicationByIdTest(){
        studentApplicationService.deleteStudentApplicationById(1);
    }

    @Test
    public void testGetAmountApplications(){
       int response= studentApplicationService.getAmountApplications();
        Assertions.assertThat(response).isEqualTo(0);
    }

}