package com.project.controller;

import com.project.model.ApplicationStatus;
import com.project.model.StudentApplication;
import com.project.service.StudentApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class StudentApplicationController {
    @Autowired
    private StudentApplicationService studentApplicationService;

    @RequestMapping("/applications")
    public String viewApplicationsPage(@Param("keyword") String keyword, Model model) {
        List<StudentApplication> applications = studentApplicationService.getAll(keyword);
        model.addAttribute("listApplications", applications);
        model.addAttribute("applicationStatusList", ApplicationStatus.values());
        if(applications.size() == 0) {
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


}
