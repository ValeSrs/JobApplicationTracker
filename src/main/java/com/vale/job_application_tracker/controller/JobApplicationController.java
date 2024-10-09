package com.vale.job_application_tracker.controller;

import com.vale.job_application_tracker.model.JobApplication;
import com.vale.job_application_tracker.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest Controller for managing job applications.
 * It handles HTTP requests to perform CRUD operations on job applications.
 */
@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {

    @Autowired
    private JobApplicationService service;

    /**
     * Retrieves a list of all job applications.
     *
     * @return List of JobApplication objects.
     */
    @GetMapping
    public List<JobApplication> getAllApplications() {
        return service.getAllApplications();
    }

    /**
     * Creates a new job application.
     *
     * @param application The job application to be created (in JSON format).
     * @return The created JobApplication object.
     */
    @PostMapping
    public JobApplication createApplication(@RequestBody JobApplication application) {
        return service.createApplication(application);
    }

    /**
     * Retrieves a job application by its ID.
     *
     * @param id The ID of the job application.
     * @return A ResponseEntity containing the job application if found, or a 404 response if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getApplicationById(@PathVariable Long id) {
        return service.getApplicationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Updates an existing job application with new data.
     *
     * @param id The ID of the job application to update.
     * @param newApplicationData The new data to update the job application with (in JSON format).
     * @return The updated JobApplication object.
     */
    @PutMapping("/{id}")
    public JobApplication updateApplication(@PathVariable Long id, @RequestBody JobApplication newApplicationData) {
        return service.updateApplication(id, newApplicationData);
    }

    /**
     * Deletes a job application by its ID.
     *
     * @param id The ID of the job application to delete.
     * @return A ResponseEntity with no content to confirm successful deletion.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        service.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }
}
