package com.visa.visa_application_service.controller;

import com.visa.visa_application_service.entity.VisaApplication;
import com.visa.visa_application_service.service.VisaApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visa")
public class VisaApplicationController {

    @Autowired
    private VisaApplicationService visaApplicationService;

    @PostMapping("/apply")
    public ResponseEntity<VisaApplication> applyForVisa(@RequestBody VisaApplication visaApplication) {
        VisaApplication savedApplication = visaApplicationService.applyForVisa(visaApplication);
        return ResponseEntity.ok(savedApplication);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisaApplication> getVisaApplication(@PathVariable Long id) {
        return visaApplicationService.getVisaApplication(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<VisaApplication>> getAllVisaApplications() {
        List<VisaApplication> applications = visaApplicationService.getAllVisaApplications();
        return ResponseEntity.ok(applications);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<VisaApplication> updateVisaApplicationStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        VisaApplication updatedApplication = visaApplicationService.updateVisaApplicationStatus(id, status);
        if (updatedApplication != null) {
            return ResponseEntity.ok(updatedApplication);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}