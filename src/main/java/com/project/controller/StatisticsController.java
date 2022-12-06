package com.project.controller;

import com.project.model.Statistics;
import com.project.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
}
