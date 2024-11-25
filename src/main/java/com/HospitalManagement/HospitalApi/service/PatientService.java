package com.HospitalManagement.HospitalApi.service;

import com.HospitalManagement.HospitalApi.model.PatientEntity;   
import com.HospitalManagement.HospitalApi.repository.PatientRepository; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<PatientEntity> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<PatientEntity> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public PatientEntity addPatient(PatientEntity patient) {
        return patientRepository.save(patient);
    }

    public PatientEntity updatePatient(Long id, PatientEntity patientDetails) {
        Optional<PatientEntity> existingPatient = patientRepository.findById(id);
        if (existingPatient.isPresent()) {
            PatientEntity patient = existingPatient.get();
            patient.setName(patientDetails.getName());
            patient.setDateOfBirth(patientDetails.getDateOfBirth());
            patient.setGender(patientDetails.getGender());
            return patientRepository.save(patient);
        }
        return null;
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}