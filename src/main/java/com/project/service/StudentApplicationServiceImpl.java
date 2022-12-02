package com.project.service;

import com.project.model.StudentApplication;
import com.project.repository.StudentApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentApplicationServiceImpl implements StudentApplicationService {
    @Autowired
    private StudentApplicationRepository studentApplicationRepository;

    @Override
    public List<StudentApplication> getAll() {
        return studentApplicationRepository.findAll();
    }

    @Override
    public void add(StudentApplication studentApplication) {
        this.studentApplicationRepository.save(studentApplication);
    }
}

