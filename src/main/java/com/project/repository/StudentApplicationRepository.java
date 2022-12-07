package com.project.repository;

import com.project.model.StudentApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentApplicationRepository extends JpaRepository<StudentApplication, Integer> {
    @Query("SELECT p FROM StudentApplication p WHERE p.studentNumber LIKE %?1%")
    public List<StudentApplication> findAll(String keyword);
}
