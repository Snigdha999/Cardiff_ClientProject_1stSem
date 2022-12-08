package com.project;

import com.project.model.Statistics;
import com.project.repository.StatisticsRepository;
import com.project.service.StatisticsService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class StatisticsServiceTest {

    @Mock
    private StatisticsRepository statisticsRepository;
    @InjectMocks
    private StatisticsService statisticsService;

    @Test
    void contextLoads() {
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllTest()
    {
        List<Statistics> statistics = new ArrayList<Statistics>();
        Statistics statistics1  = new Statistics(1,"22", 1, 2);
        Statistics statistics2 = new Statistics(2, "22", 13, 22);
        Statistics statistics3 = new Statistics(3, "22", 12, 22);

        statistics.add(statistics1);
        statistics.add(statistics2);
        statistics.add(statistics3);

        when(statisticsRepository.findAll()).thenReturn(statistics);

        //test
        List<Statistics> statisticsList = statisticsService.getAll();
        assertEquals(3, statisticsList.size());
        verify(statisticsRepository, times(1)).findAll();
    }

}
