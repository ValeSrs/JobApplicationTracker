package com.vale.job_application_tracker.service;


import com.vale.job_application_tracker.model.JobApplication;
import com.vale.job_application_tracker.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository repository;

    public List<JobApplication> getAllApplications() {
        return repository.findAll();
    }

    public JobApplication createApplication(JobApplication application) {
        return repository.save(application);
    }

    public Optional<JobApplication> getApplicationById(Long id) {
        return repository.findById(id);
    }

    public JobApplication updateApplication(Long id, JobApplication newApplicationData) {
        return repository.findById(id)
                .map(application -> {
                    application.setCompany(newApplicationData.getCompany());
                    application.setPosition(newApplicationData.getPosition());
                    application.setApplicationDate(newApplicationData.getApplicationDate());
                    application.setStatus(newApplicationData.getStatus());
                    application.setNotes(newApplicationData.getNotes());
                    return repository.save(application);
                })
                .orElseThrow();
    }

    public void deleteApplication(Long id) {
        repository.deleteById(id);
    }
}
