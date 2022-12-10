package com.project.controller;

import com.project.model.ApplicationExcelExporter;
import com.project.model.Statistics;
import com.project.model.StatisticsExcelExporter;
import com.project.model.StudentApplication;
import com.project.service.StatisticsService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

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

    @GetMapping("/exportStatistics")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        DateFormat dateFormatter = new SimpleDateFormat("");
        String headerValue = "attachment; filename=statistics.xlsx";
        response.setHeader(headerKey, headerValue);
        List<Statistics> statistics = statisticsService.getAll();
        StatisticsExcelExporter excelExporter = new StatisticsExcelExporter(statistics);
        excelExporter.export(response);
    }
}
