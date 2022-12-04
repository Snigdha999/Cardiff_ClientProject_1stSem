package com.project.service;

import com.project.model.StudentApplication;

import java.util.List;

public interface StudentApplicationService {
    List<StudentApplication> getAll();

    void add(StudentApplication studentApplication);
}