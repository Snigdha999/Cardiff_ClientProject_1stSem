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

    /* Getting data from the application table by id
     * @param id
     * @return StudentApplication
     */
    public StudentApplication getStudentApplicationById(int id);

    /* Delete the data in the Application table by id
     * @param id
     */
    public void deleteStudentApplicationById(int id);

}