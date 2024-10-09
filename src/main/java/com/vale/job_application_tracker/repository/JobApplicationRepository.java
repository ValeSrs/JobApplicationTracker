package com.vale.job_application_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vale.job_application_tracker.model.JobApplication;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    // other methodes
}
