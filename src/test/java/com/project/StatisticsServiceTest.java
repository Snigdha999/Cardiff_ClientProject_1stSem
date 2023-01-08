package com.project;

import com.project.model.Statistics;
import com.project.service.StatisticsService;
import com.project.repository.StatisticsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.data.domain.Page;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
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
    public void whenDeleteAllStatistics_thenReturnNoStatistics() {
        List<Statistics> statistics = statisticsService.getAll();
        statisticsService.deleteAll();
        Assertions.assertThat(statistics.size()).isEqualTo(0);
    }

    @Test
    public void testFindStatisticPaginated(){
        Page<Statistics> page= statisticsService.findStatisticPaginated(2,5,"ucasCode","asc");
        Assertions.assertThat(page.getSize()).isEqualTo(5);

    }

    @Test
    void testFindAllByStudyYear_noStatistics() {
        // mock the StatisticsRepository to return an empty list
        StatisticsRepository mockRepo = mock(StatisticsRepository.class);
        when(mockRepo.findAll()).thenReturn(List.of());

        // mock the StatisticsService to call the real findAllByStudyYear method
        StatisticsService mockService = mock(StatisticsService.class);
        when(mockService.findAllByStudyYear()).thenCallRealMethod();

        List<Statistics> result = mockService.findAllByStudyYear();

        // assert that the result list has a single element with 0 places
        assertEquals(1, result.size());
        assertEquals(0, result.get(0).getPlaces());
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
    @Test
    public void deleteStatisticsByIdTests() {
        statisticsService.deleteStatisticsById(100);
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
