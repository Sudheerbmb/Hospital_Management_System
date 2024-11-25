package com.HospitalManagement.HospitalApi.repository;

import com.HospitalManagement.HospitalApi.model.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
}

