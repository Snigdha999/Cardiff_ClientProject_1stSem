package com.project;

import com.project.model.ApplicationStatus;
import com.project.model.StudentApplication;
import com.project.service.StudentApplicationService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentApplicationServiceTest {

    @Autowired
    private StudentApplicationService studentApplicationService;

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
        studentApplicationService.deleteStudentApplicationById(79);
    }

    @Test
    public void testGetAmountApplications(){
       int response= studentApplicationService.getAmountApplications();
        Assertions.assertThat(response).isEqualTo(0);
    }

    @Test
    public void whenGetAllStudentApplication_thenReturnAllStudentApplication() {
        StudentApplication application = new StudentApplication();
        application.setStudentNumber("09456712");
        studentApplicationService.add(application);
        List<StudentApplication> studentApplications = studentApplicationService.getAll("09456712");
        Assertions.assertThat(studentApplications.size()).isGreaterThan(0);
    }

    @Test
    public void whenParseExcelApplicationStatus_thenArrayOfApplicationStatusesReturned(){
        // creating new application object
        StudentApplication application = new StudentApplication();
        // crating array list for an expected application status with values CF and UF
        ArrayList<ApplicationStatus> expected = new ArrayList<>();
        expected.add(ApplicationStatus.CF);
        expected.add(ApplicationStatus.UF);
        List<ApplicationStatus> response = application.parseExcelApplicationStatus("CF,UF");
        // comparing response with an expected value
        Assertions.assertThat(response).isEqualTo(expected);
    }

    @Test
    public void whenDisplayApplicationStatusCalled_thenFormattedStringWithStatusValuesReturned(){
        // creating new application object
        StudentApplication application = new StudentApplication();
        // setting application statuses CF and UF
        ArrayList<ApplicationStatus> applicationStatuses = new ArrayList<>();
        applicationStatuses.add(ApplicationStatus.CF);
        applicationStatuses.add(ApplicationStatus.UF);
        application.setApplicationStatus(applicationStatuses);
        // calling displayApplicationStatus method
        String response = application.displayApplicationStatus();
        // comparing response with an expected value
        Assertions.assertThat(response).isEqualTo("CF,UF");
    }

}