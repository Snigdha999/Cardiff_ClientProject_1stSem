package com.project.controller;

import com.project.model.ApplicationStatus;
import com.project.model.Statistics;
import com.project.model.StudentApplication;
import com.project.service.StatisticsExcelService;
import com.project.service.StatisticsService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

        return findStatisticPaginated(1,model);
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

    @GetMapping("/statisticPage/{statisticPageNo}")
    public String findStatisticPaginated(@PathVariable (value = "statisticPageNo") int statisticPageNo,
                                           Model model){
        int statisticPageSize = 4;

        Page<Statistics> statisticPage = statisticsService.findStatisticPaginated(statisticPageNo, statisticPageSize);
        List<Statistics> statistics = statisticPage.getContent();

        model.addAttribute("currentStatisticPage", statisticPageNo);
        model.addAttribute("statisticTotalPages", statisticPage.getTotalPages());
        model.addAttribute("statisticTotalItems", statisticPage.getTotalElements());

        model.addAttribute("listStatistics", statistics);


        return "statistics";

    }
}
