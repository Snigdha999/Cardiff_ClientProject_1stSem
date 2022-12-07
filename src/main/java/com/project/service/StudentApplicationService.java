package com.project.service;

import com.project.model.StudentApplication;

import java.util.List;

public interface StudentApplicationService {

    /* Getting all the data in the Application table
     * @return List
     */
    public List<StudentApplication> getAll(String studentNo);

    /* Adding all the data in the Application table
     * @return List
     */
    public void add(StudentApplication studentApplication);

    StudentApplication getStudentApplicationById(int id);

    void deleteStudentApplicationById(int id);

    public int getAmountApplications();

    public int getAmountOfOffers();
}