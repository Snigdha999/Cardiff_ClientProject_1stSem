package com.project.controller;

import com.project.model.ApplicationStatus;
import com.project.model.StudentApplication;
import com.project.service.StudentApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class StudentApplicationController {
    @Autowired
    private StudentApplicationService studentApplicationService;

    @GetMapping("/applications")
    public String viewApplicationsPage(Model model) {
        List<StudentApplication> applications = studentApplicationService.getAll();
        model.addAttribute("listApplications", applications);
        model.addAttribute("applicationStatusList", ApplicationStatus.values());
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
}
