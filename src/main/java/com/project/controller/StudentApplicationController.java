package com.project.controller;

import com.project.model.Statistics;
import com.project.service.ApplicationExcelService;
import com.project.model.ApplicationStatus;
import com.project.model.StudentApplication;
import com.project.service.StatisticsExcelService;
import com.project.service.StudentApplicationService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
public class StudentApplicationController {
    @Autowired
    private StudentApplicationService studentApplicationService;

    @RequestMapping("/applications")
    public String viewApplicationsPage(@Param("keyword") String keyword, Model model) {
        List<StudentApplication> applications = studentApplicationService.getAll(keyword);
        model.addAttribute("listApplications", applications);
        model.addAttribute("applicationStatusList", ApplicationStatus.values());
        if(applications.size() == 0 && keyword != null) {
            return "noApplicationsFound";
        }
        return "applications";
    }

    @PostMapping("/addApplication")
    public String addApplication(@ModelAttribute("newApplication") StudentApplication studentApplication) {
        studentApplicationService.add(studentApplication);
        return "redirect:/applications";
    }


    @GetMapping("/deleteStudentApplication/{id}")
    public String deleteStudentApplication(@PathVariable (value = "id") int id){

        //Call delete students' applications method
        this.studentApplicationService.deleteStudentApplicationById(id);
        return "redirect:/applications";
    }

    @GetMapping("/getStudentApplication/{id}")
    public String getStudentApplication(@PathVariable (value = "id") int id, Model model){
        StudentApplication application = studentApplicationService.getStudentApplicationById(id);
        model.addAttribute("applicationStatusList", ApplicationStatus.values());
        model.addAttribute("updateApplication", application);
        return "updateApplication";
    }

    @PostMapping("/updateStudentApplication/{id}")
    public String updateStudentApplication(@PathVariable (value = "id") int id, @ModelAttribute("newApplication") StudentApplication studentApplication){
        studentApplicationService.add(studentApplication);
        return "redirect:/applications";
    }

    @GetMapping("/exportApplications")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=applications.xlsx";
        response.setHeader(headerKey, headerValue);
        List<StudentApplication> applications = studentApplicationService.getAll(null);
        ApplicationExcelService excelExporter = new ApplicationExcelService(applications);
        excelExporter.export(response);
    }

    @PostMapping("/importApplications")
    public String importFromExcel(@RequestParam("file") MultipartFile files) {
        try {
            InputStream inputStream = files.getInputStream();
            ApplicationExcelService excelImporter = new ApplicationExcelService(inputStream);
            List<StudentApplication> applicationList =  excelImporter.importExcel();
            for(StudentApplication application: applicationList) {
                studentApplicationService.add(application);
            }
        } catch (IOException e) {
            return "redirect:/errorView";
        }
        return "redirect:/applications";
    }

    @GetMapping("/deleteAllApplications")
    public String deleteAllApplications(Model model) {
        studentApplicationService.deleteAll();
        return "redirect:/applications";
    }
        
    @GetMapping("/getStudentApplicationStatus/{id}")
    public String getStudentApplicationStatus(@PathVariable (value = "id") int id, Model model){
        StudentApplication application = studentApplicationService.getStudentApplicationById(id);
        model.addAttribute("applicationStatusList", ApplicationStatus.values());
        model.addAttribute("updateApplication", application);
        return "updateApplicationStatus";
    }

    @PostMapping("/updateStudentApplicationStatus/{id}")
    public String updateStudentApplicationStatus(@PathVariable (value = "id") int id, @ModelAttribute("newApplication") StudentApplication newApplication){
        StudentApplication application = studentApplicationService.getStudentApplicationById(id);
        List<ApplicationStatus> status = newApplication.getApplicationStatus();
        application.setApplicationStatus(status);
        studentApplicationService.add(application);
        return "redirect:/applications";
    }
}
