package com.project.service;

import com.project.model.Statistics;
import com.project.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private StatisticsRepository statisticsRepository;

    @Override
    public List<Statistics> getAll() {
        return statisticsRepository.findAll();
    }

    @Override
    public void add(Statistics statistics) {
        this.statisticsRepository.save(statistics);
    }
}
