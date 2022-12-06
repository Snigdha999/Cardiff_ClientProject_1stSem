package com.project.service;

import com.project.model.Statistics;
import com.project.model.StudentApplication;

import java.util.List;

public interface StatisticsService {

    /* Getting all the data in the statistics table
     * @return List
     */
    public List<Statistics> getAll();

    /* Adding data in the statistics table
     * @param statistics
     */
    public void add(Statistics statistics);

    Statistics getStatisticsById(int id);
}
