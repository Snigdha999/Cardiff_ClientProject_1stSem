package com.project.service;

import com.project.model.Statistics;
import com.project.model.StudentApplication;
import org.springframework.data.domain.Page;

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

    /* Getting data from the statistics table by id
     * @param id
     * @return Statistics
     */
    public Statistics getStatisticsById(int id);

    /* Delete the data in the Statistics table by id
     * @param id
     */
    public void deleteStatisticsById(int id);

    /* Find all the data in the Statistics table on the basis of study year
     * @return List
     */
    public List<Statistics> findAllByStudyYear();

    /* Delete all the data
     */
    public void deleteAll();

    Page<Statistics> findStatisticPaginated(int statisticPageNo, int statisticPageSize, String statisticSortField, String statisticSortDirection);

}
