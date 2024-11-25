package com.HospitalManagement.HospitalApi.service;

import com.HospitalManagement.HospitalApi.model.DoctorEntity;   
import com.HospitalManagement.HospitalApi.repository.DoctorRepository;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorEntity> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<DoctorEntity> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public DoctorEntity addDoctor(DoctorEntity doctor) {
        return doctorRepository.save(doctor);
    }

    public DoctorEntity updateDoctor(Long id, DoctorEntity doctorDetails) {
        Optional<DoctorEntity> existingDoctor = doctorRepository.findById(id);
        if (existingDoctor.isPresent()) {
            DoctorEntity doctor = existingDoctor.get();
            doctor.setName(doctorDetails.getName());
            doctor.setSpecialization(doctorDetails.getSpecialization());
            return doctorRepository.save(doctor);
        }
        return null;
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
