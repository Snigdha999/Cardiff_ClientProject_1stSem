package com.project.service;

import com.project.model.StudentApplication;
import com.project.repository.StudentApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<StudentApplication> getAll() {
        return studentApplicationRepository.findAll();
    }

    /* Adding all the data in the Application table
     * @return List
     */
    @Override
    public void add(StudentApplication studentApplication) {
        this.studentApplicationRepository.save(studentApplication);
    }


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

    @Override
    public void deleteStudentApplicationById(int id) {
        this.studentApplicationRepository.deleteById(id);
    }


    @Override
    public int getAmountApplications(){
        List<StudentApplication> applications = studentApplicationRepository.findAll();

        return applications.size();
    }

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


}