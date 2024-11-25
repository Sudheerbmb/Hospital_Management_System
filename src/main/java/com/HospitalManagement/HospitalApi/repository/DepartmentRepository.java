package com.HospitalManagement.HospitalApi.repository;

import com.HospitalManagement.HospitalApi.model.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}
