package com.project.service;

import com.project.model.Statistics;
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

    /* Predict the data of places in the Statistics table for upcoming year
     * @return int
     */
    public int predictPlaces();

    /* Predict the data of offers in the Statistics table for upcoming year
     * @return int
     */
    public int predictOffers();


    /* Getting statistics data by their page number
     * @return List
     */
    public Page<Statistics> findStatisticPaginated(int statisticPageNo, int statisticPageSize, String statisticSortField, String statisticSortDirection);
}
