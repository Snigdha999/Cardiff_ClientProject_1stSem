package com.project.service;

import com.project.model.Statistics;
import com.project.model.StudentApplication;
import com.project.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

}
