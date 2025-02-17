package com.visa.visa_application_service.service;

import com.visa.visa_application_service.entity.VisaApplication;

import java.util.List;
import java.util.Optional;

public interface VisaApplicationService {
    VisaApplication applyForVisa(VisaApplication visaApplication);
    Optional<VisaApplication> getVisaApplication(Long id);
    List<VisaApplication> getAllVisaApplications();
    VisaApplication updateVisaApplicationStatus(Long id, String status);
}