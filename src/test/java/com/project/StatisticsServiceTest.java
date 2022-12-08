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
    void contextLoads() {
    }

    @Test
    public void whenGetAllStatistics_thenReturnAllStatistics() {
        List<Statistics> statistics = statisticsService.getAll();
        Assertions.assertThat(statistics.size()).isGreaterThan(0);
    }


}
