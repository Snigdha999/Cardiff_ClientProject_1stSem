package com.project.repository;

import com.project.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Integer> {
    @Query(value = "SELECT * FROM statistics  WHERE statistics.study_year =?1 ",nativeQuery = true)
    public List<Statistics> findAllByStudyYear(String keyword);
}
