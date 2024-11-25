package com.HospitalManagement.HospitalApi.controller;

import com.HospitalManagement.HospitalApi.model.DoctorEntity;
import com.HospitalManagement.HospitalApi.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    public List<DoctorEntity> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @GetMapping("/{id}")
    public DoctorEntity getDoctorById(@PathVariable Long id) {
        Optional<DoctorEntity> doctor = doctorRepository.findById(id);
        return doctor.orElse(null);
    }

    @PostMapping
    public DoctorEntity createDoctor(@RequestBody DoctorEntity doctor) {
        return doctorRepository.save(doctor);
    }

    @PutMapping("/{id}")
    public DoctorEntity updateDoctor(@PathVariable Long id, @RequestBody DoctorEntity doctorDetails) {
        Optional<DoctorEntity> doctorOptional = doctorRepository.findById(id);
        if (doctorOptional.isPresent()) {
            DoctorEntity doctor = doctorOptional.get();
            doctor.setName(doctorDetails.getName());
            doctor.setSpecialization(doctorDetails.getSpecialization());
            return doctorRepository.save(doctor);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorRepository.deleteById(id);
    }

    // New Search Endpoint
    @GetMapping("/search")
    public List<DoctorEntity> searchDoctorsByName(@RequestParam String name) {
        return doctorRepository.findByNameContainingIgnoreCase(name);
    }
}

