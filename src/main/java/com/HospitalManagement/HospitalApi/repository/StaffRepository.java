package com.HospitalManagement.HospitalApi.repository;

import com.HospitalManagement.HospitalApi.model.StaffEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<StaffEntity, Long> {
    List<StaffEntity> findByDepartmentId(Long departmentId);
}
