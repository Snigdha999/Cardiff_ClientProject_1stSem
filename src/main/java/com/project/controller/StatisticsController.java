package com.project.controller;

import com.project.model.Statistics;
import com.project.service.StatisticsExcelService;
import com.project.service.StatisticsService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        String headerValue = "attachment; filename=statistics.xlsx";
        response.setHeader(headerKey, headerValue);
        List<Statistics> statistics = statisticsService.getAll();
        StatisticsExcelService excelExporter = new StatisticsExcelService(statistics);
        excelExporter.export(response);
    }

    @PostMapping("/importStatistics")
    public String importFromExcel(@RequestParam("file") MultipartFile files) {
        try {
            InputStream inputStream = files.getInputStream();
            StatisticsExcelService excelImporter = new StatisticsExcelService(inputStream);
            List<Statistics> statisticsList =  excelImporter.importExcel();
            for(Statistics statistics: statisticsList) {
                statisticsService.add(statistics);
            }
        } catch (IOException e) {
            return "redirect:/errorView";
        }
        return "redirect:/statistics";
    }

    @GetMapping("/deleteAllStatistics")
    public String deleteAllStatistics(Model model) {
        statisticsService.deleteAll();
        return "redirect:/statistics";
    }
}
