package com.project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {

    @RequestMapping("/pageApplication")
    public String pageApplication(Model model){
        model.addAttribute("applicationPage","Applications");
        return "applications";
    }

    @RequestMapping("/pageStatistics")
    public String pageStatistics(Model model){
        model.addAttribute("statisticPage","Statistics");
        return "statistics";
    }


}
