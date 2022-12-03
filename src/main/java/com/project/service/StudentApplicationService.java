package com.project.service;

import com.project.model.StudentApplication;

import java.util.List;

public interface StudentApplicationService {

    /* Getting all the data in the Application table
     * @return List
     */
    public List<StudentApplication> getAll();

    /* Adding all the data in the Application table
     * @return List
     */
    public void add(StudentApplication studentApplication);
}