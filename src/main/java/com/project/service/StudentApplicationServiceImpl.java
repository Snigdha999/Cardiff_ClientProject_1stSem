package com.project.service;

import com.project.model.StudentApplication;
import com.project.repository.StudentApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentApplicationServiceImpl implements StudentApplicationService {
    @Autowired
    private StudentApplicationRepository studentApplicationRepository;

    /* Getting all the data in the Application table
     * @return List
     */
    @Override
    public List<StudentApplication> getAll(String studentNo) {
        if(studentNo != null) {
            return studentApplicationRepository.findAll(studentNo);
        }
        return studentApplicationRepository.findAll();
    }

    /* Adding all the data in the Application table
     * @param StudentApplication
     */
    @Override
    public void add(StudentApplication studentApplication) {
        this.studentApplicationRepository.save(studentApplication);
    }

    /* Getting data from the application table by id
     * @param id
     * @return StudentApplication
     */
    @Override
    public StudentApplication getStudentApplicationById(int id){
        Optional<StudentApplication> optional = studentApplicationRepository.findById(id);
        StudentApplication studentApplication = null;
        if(optional.isPresent()){
            studentApplication = optional.get();
        }else{
            throw new RuntimeException(" The student's application not found for id :: " + id);

        }
        return studentApplication;

    }

    /* Delete the data in the Application table by id
     * @param id
     */
    @Override
    public void deleteStudentApplicationById(int id) {
        this.studentApplicationRepository.deleteById(id);
    }

    /* Fetching the amount of application data
     * @return int
     */
    @Override
    public int getAmountApplications(){
        List<StudentApplication> applications = studentApplicationRepository.findAll();

        return applications.size();
    }

    /* Fetching the amount of offers data
     * @return int
     */
    @Override
    public int getAmountOfOffers(){
        int counter = 0;
        List<StudentApplication> applications = studentApplicationRepository.findAll();
        for(int i=0; i < applications.size(); i++){
            String status = applications.get(i).displayApplicationStatus();
            // status = "CFUF" , offer + 1
            if(status.equals("CFUF")){
                counter += 1;
            }
        }
        return counter;
    }


    /* Creating the method of pagination for students' applications
     * @param applicationPageNo
     */
    @Override
    public Page<StudentApplication> findApplicationPaginated(int applicationPageNo, int applicationPageSize) {
        Pageable applicationPageable = PageRequest.of(applicationPageNo - 1, applicationPageSize);
        return this.studentApplicationRepository.findAll(applicationPageable);
    }


}
