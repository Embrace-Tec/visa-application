package com.visa.visa_application_service.repository;

import com.visa.visa_application_service.entity.VisaApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisaApplicationRepository extends JpaRepository<VisaApplication, Long> {
}