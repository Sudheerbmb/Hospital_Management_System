package com.HospitalManagement.HospitalApi.controller;

import com.HospitalManagement.HospitalApi.model.PatientEntity;
import com.HospitalManagement.HospitalApi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public List<PatientEntity> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public PatientEntity getPatientById(@PathVariable Long id) {
        Optional<PatientEntity> patient = patientRepository.findById(id);
        return patient.orElse(null);
    }

    @PostMapping
    public PatientEntity createPatient(@RequestBody PatientEntity patient) {
        return patientRepository.save(patient);
    }

    @PutMapping("/{id}")
    public PatientEntity updatePatient(@PathVariable Long id, @RequestBody PatientEntity patientDetails) {
        Optional<PatientEntity> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            PatientEntity patient = patientOptional.get();
            patient.setName(patientDetails.getName());
            patient.setDateOfBirth(patientDetails.getDateOfBirth());
            patient.setGender(patientDetails.getGender());
            return patientRepository.save(patient);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
    }
}
