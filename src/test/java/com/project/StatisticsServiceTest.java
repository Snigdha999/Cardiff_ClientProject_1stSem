package com.project;

import com.project.model.Statistics;
import com.project.repository.StatisticsRepository;
import com.project.service.StatisticsService;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatisticsServiceTest {

    @Mock
    private StatisticsRepository statisticsRepository;

    @InjectMocks
    private StatisticsService statisticsService;

    @Test
    void contextLoads() {
    }

    /*@Test
    public void testGetAll() {
        List<Statistics> statistics = (List<Statistics>) new Statistics();
        statistics.add(new Statistics());
        given(statisticsRepository.findAll()).willReturn(statistics);
        List<Statistics> expected = statisticsService.getAll();
        assertEquals(expected, statistics);
        verify(statisticsRepository).findAll();

    }*/
}
