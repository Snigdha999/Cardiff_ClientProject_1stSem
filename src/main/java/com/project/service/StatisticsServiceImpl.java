package com.project.service;

import com.project.model.Statistics;
import com.project.model.StudentApplication;
import com.project.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private StatisticsRepository statisticsRepository;

    /* Getting all the data in the statistics table
     * @return List
     */
    @Override
    public List<Statistics> getAll() {
        return statisticsRepository.findAll();
    }

    /* Adding data in the statistics table
     * @param statistics
     */
    @Override
    public void add(Statistics statistics) {
        this.statisticsRepository.save(statistics);
    }

    /* Getting data from the statistics table by id
     * @param id
     * @return Statistics
     */
    @Override
    public Statistics  getStatisticsById(int id){
        Optional<Statistics> optional = statisticsRepository.findById(id);
        Statistics statistics = null;
        if(optional.isPresent()){
            statistics = optional.get();
        }else{
            throw new RuntimeException(" The data not found for id :: " + id);

        }
        return statistics;

    }

    /* Delete the data in the Statistics table by id
     * @param id
     */
    @Override
    public void deleteStatisticsById(int id) {
        this.statisticsRepository.deleteById(id);
    }

    /* Find all the data in the Statistics table on the basis of study year
     * @return List
     */
    @Override
    public List<Statistics> findAllByStudyYear() {
        //If data is available, the list information is processed in descending
        // order by academic year field and returns which row of data for
        // the year with the largest number.
        if(this.statisticsRepository.findAll().size()>0){
            return this.statisticsRepository.findAllByStudyYearOrderByStudyYearDesc();
        }
        else{
            List<Statistics> statisticsList = new ArrayList<Statistics>();
            Statistics s=new Statistics();
            s.setPlaces(0);
            statisticsList.add(s);

            //Please don't delete the code below.
//        //Get Calendar Object
//        Calendar cal = Calendar.getInstance();
//        //Get the current year based on the calendar object.
//        int year = cal.get(Calendar.YEAR)%100;
//        //Get next year
//        int nextYear =(year+1)%100;
//        //Spliced into the form of the string "22/23".
//        String keyword =Integer.toString(year)+"/"+Integer.toString(nextYear);
//        System.out.println(keyword);
//
        return statisticsList;
        }
    }

    /* Delete all the data
     */
    @Override
    public void deleteAll() {
        statisticsRepository.deleteAll();
    }


    @Override

    public int predictPlaces() {
        double profit = 0;
        double avgProfit = 0;
        double prediction = 0;
        List<Statistics> statistics = statisticsRepository.findAll();
        if (statistics.size() != 0) {
            for (int i = 0; i < statistics.size()-1; i++) {
                    profit += statistics.get(i+1).getPlaces() - statistics.get(i).getPlaces();
            }
            avgProfit = profit / (statistics.size()-1);
            prediction = statistics.get(statistics.size()-1).getPlaces() + avgProfit ;
        }
        return (int) prediction;
    }

    @Override
    public int predictOffers() {
        double profit = 0;
        double avgProfit = 0;
        double prediction = 0;
        List<Statistics> statistics = statisticsRepository.findAll();
        if (statistics.size() != 0) {
            for (int i = 0; i < statistics.size()-1; i++) {
                    profit += statistics.get(i+1).getOffers() - statistics.get(i).getOffers();

            }
            avgProfit = profit / (statistics.size()-1);
            prediction = statistics.get(statistics.size()-1).getOffers() + avgProfit ;
        }
        return (int) prediction;
    }

    public Page<Statistics> findStatisticPaginated(int statisticPageNo, int statisticPageSize, String statisticSortField, String statisticSortDirection) {
        Sort statisticSort = statisticSortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(statisticSortField).ascending() :
                Sort.by(statisticSortField).descending();

        Pageable statisticPageable = PageRequest.of(statisticPageNo - 1, statisticPageSize, statisticSort);
        return this.statisticsRepository.findAll(statisticPageable);
    }


}
