package com.HospitalManagement.HospitalApi.repository;

import com.HospitalManagement.HospitalApi.model.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
    List<DoctorEntity> findByNameContainingIgnoreCase(String name);
}
