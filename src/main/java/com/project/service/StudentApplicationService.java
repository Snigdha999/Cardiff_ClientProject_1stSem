package com.project.service;

import  com.project.model.StudentApplication;
import org.springframework.data.domain.Page;

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

    /* Getting data from the application table by id
     * @param id
     * @return StudentApplication
     */
    public StudentApplication getStudentApplicationById(int id);

    /* Delete the data in the Application table by id
     * @param id
     */
    public void deleteStudentApplicationById(int id);

    /* Fetching the amount of application data
     * @return int
     */
    public int getAmountApplications();

    /* Fetching the amount of offers data
     * @return int
     */
    public int getAmountOfOffers();

    /* Creating the method of pagination for students' applications
     * @param applicationPageNo
     */
    Page<StudentApplication> findApplicationPaginated(int applicationPageNo, int applicationPageSize, String applicationSortField, String applicationSortDirection);

    /* Delete all the data
     */
    public void deleteAll();
}