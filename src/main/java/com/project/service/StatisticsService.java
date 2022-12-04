package com.project.service;

import com.project.model.Statistics;

import java.util.List;

public interface StatisticsService {
    List<Statistics> getAll();

    void add(Statistics statistics);
}
