package com.HospitalManagement.HospitalApi.repository;

import com.HospitalManagement.HospitalApi.model.AppointmentEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
    List<AppointmentEntity> findByPatientId(Long patientId);
    List<AppointmentEntity> findByDoctorId(Long doctorId);
}
