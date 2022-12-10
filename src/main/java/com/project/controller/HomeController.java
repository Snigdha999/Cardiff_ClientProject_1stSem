package com.project.controller;

import com.project.model.Statistics;
import com.project.service.StatisticsService;
import com.project.service.StudentApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.time.chrono.JapaneseEra.values;

@Controller
public class HomeController {

    @Autowired
    private StudentApplicationService applicationService;

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/home")
    public String home(Model model) {
        List<Statistics> statisticsList = statisticsService.getAll();

        List<String> dataNames = new ArrayList<>();
        List<Integer> dataOffers = new ArrayList<>();
        List<Integer> dataPlaces = new ArrayList<>();
        for(Statistics statistics: statisticsList) {
            dataNames.add(statistics.getStudyYear());
            dataOffers.add(statistics.getOffers());
            dataPlaces.add(statistics.getPlaces());
        }

        if(dataNames.size() != 0 && dataOffers.size() != 0 && dataPlaces.size() != 0) {
            model.addAttribute("dataNames",dataNames);
            model.addAttribute("dataOffers",dataOffers);
            model.addAttribute("dataPlaces",dataPlaces);
        }
        model.addAttribute("amountOfPlace", statisticsService.findAllByStudyYear().get(0).getPlaces());
        model.addAttribute("amountOfApplications", applicationService.getAmountApplications());
        model.addAttribute("amountOfOffers", applicationService.getAmountOfOffers());

        return "homepage";

    }
}