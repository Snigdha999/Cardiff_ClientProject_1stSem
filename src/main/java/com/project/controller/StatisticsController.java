package com.project.controller;

import com.project.model.ApplicationStatus;
import com.project.model.Statistics;
import com.project.model.StudentApplication;
import com.project.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

@Controller
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/statistics")
    public String viewStatisticsPage(Model model) {
        model.addAttribute("listStatistics", statisticsService.getAll());
        return "statistics";
    }

    @PostMapping("/addStatistics")
    public String addStatistics(@ModelAttribute("statisticsItem") Statistics statistics) {
        statisticsService.add(statistics);
        return "redirect:/statistics";
    }

    @GetMapping("/deleteStatistics/{id}")
    public String deleteStatistics(@PathVariable (value = "id") int id){
        //Call delete student's statistics method
        this.statisticsService.deleteStatisticsById(id);
        return "redirect:/statistics";
    }

    @GetMapping("/getStatistics/{id}")
    public String getStatistics(@PathVariable (value = "id") int id, Model model){
        Statistics statistics = statisticsService.getStatisticsById(id);
        model.addAttribute("updateStatistics", statistics);
        return "updateStatistics";
    }

    @PostMapping("/updateStatistics/{id}")
    public String updateStudentApplication(@PathVariable (value = "id") int id, @ModelAttribute("newStatistics") Statistics statistics){
        statisticsService.add(statistics);
        return "redirect:/statistics";
    }

}
