package com.project;

import com.project.model.Statistics;
import com.project.service.StatisticsService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticsServiceTest {

    @Autowired
    private StatisticsService statisticsService;

    @Test
    public void whenGetAllStatistics_thenReturnAllStatistics() {
        List<Statistics> statistics = statisticsService.getAll();
        Assertions.assertThat(statistics.size()).isGreaterThan(0);
    }

    @Test
    public void addTest() {
        Statistics statistics=new Statistics();
         statisticsService.add(statistics);
    }

    @Test
    public void getStatisticsByIdTest() {
        Statistics statistics = statisticsService.getStatisticsById(96);
        Assertions.assertThat(statistics.getId()).isEqualTo(96);
    }

    @Test
    public void findAllByStudyYearTests() {
        List<Statistics> statistics = statisticsService.getAll();
        Assertions.assertThat(statistics.size()).isGreaterThan(0);
    }
   // @Test
    public void deleteStatisticsByIdTests() {
        statisticsService.deleteStatisticsById(122);
    }
    @Test
    public void predictPlacesTests(){
        int response=statisticsService.predictPlaces();
        Assertions.assertThat(response).isLessThan(0);
    }

    @Test
    public void predictOffersTests() {
        int response = statisticsService.predictOffers();
        Assertions.assertThat(response).isLessThan(0);
    }

}
