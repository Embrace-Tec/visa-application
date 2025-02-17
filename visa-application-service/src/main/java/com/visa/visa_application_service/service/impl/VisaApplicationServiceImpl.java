package com.visa.visa_application_service.service.impl;

import com.visa.visa_application_service.entity.VisaApplication;
import com.visa.visa_application_service.repository.VisaApplicationRepository;
import com.visa.visa_application_service.service.VisaApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VisaApplicationServiceImpl implements VisaApplicationService {

    @Autowired
    private VisaApplicationRepository visaApplicationRepository;

    @Override
    public VisaApplication applyForVisa(VisaApplication visaApplication) {
        visaApplication.setSubmissionDate(new Date());
        return visaApplicationRepository.save(visaApplication);
    }

    @Override
    public Optional<VisaApplication> getVisaApplication(Long id) {
        return visaApplicationRepository.findById(id);
    }

    @Override
    public List<VisaApplication> getAllVisaApplications() {
        return visaApplicationRepository.findAll();
    }

    @Override
    public VisaApplication updateVisaApplicationStatus(Long id, String status) {
        Optional<VisaApplication> optionalVisaApplication = visaApplicationRepository.findById(id);
        if (optionalVisaApplication.isPresent()) {
            VisaApplication visaApplication = optionalVisaApplication.get();
            visaApplication.setStatus(status);
            return visaApplicationRepository.save(visaApplication);
        }
        return null;
    }
}