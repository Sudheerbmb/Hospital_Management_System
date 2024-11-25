package com.HospitalManagement.HospitalApi.controller;

import com.HospitalManagement.HospitalApi.model.AppointmentEntity;
import com.HospitalManagement.HospitalApi.repository.AppointmentRepository;
import com.HospitalManagement.HospitalApi.service.AppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping
    public List<AppointmentEntity> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public AppointmentEntity getAppointmentById(@PathVariable Long id) {
        Optional<AppointmentEntity> appointment = appointmentRepository.findById(id);
        return appointment.orElse(null);
    }

    @PostMapping
    public AppointmentEntity createAppointment(@RequestBody AppointmentEntity appointment) {
        return appointmentRepository.save(appointment);
    }

    @PutMapping("/{id}")
    public AppointmentEntity updateAppointment(@PathVariable Long id, @RequestBody AppointmentEntity appointmentDetails) {
        Optional<AppointmentEntity> appointmentOptional = appointmentRepository.findById(id);
        if (appointmentOptional.isPresent()) {
            AppointmentEntity appointment = appointmentOptional.get();
            appointment.setAppointmentDate(appointmentDetails.getAppointmentDate());
            appointment.setPatient(appointmentDetails.getPatient());
            appointment.setDoctor(appointmentDetails.getDoctor());
            return appointmentRepository.save(appointment);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentRepository.deleteById(id);
    }

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/patient/{patientId}")
    public List<AppointmentEntity> getAppointmentsByPatient(@PathVariable Long patientId){
        return appointmentService.getAppointmentsByPatientId(patientId);
    }

    @GetMapping("/doctor/{doctorId}")
    public List<AppointmentEntity> getAppointmentsByDoctor(@PathVariable Long doctorId){
        return appointmentService.getAppointmentsByDoctorId(doctorId);
    }


    
}
