package com.project.service;

import com.project.model.Application;
import com.project.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public List<Application> getAll() {
        return applicationRepository.findAll();
    }

    @Override
    public void add(Application application) {
        this.applicationRepository.save(application);
    }
}

