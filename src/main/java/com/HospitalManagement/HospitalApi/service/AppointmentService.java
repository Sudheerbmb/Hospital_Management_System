package com.HospitalManagement.HospitalApi.service;

import com.HospitalManagement.HospitalApi.model.AppointmentEntity;
import com.HospitalManagement.HospitalApi.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<AppointmentEntity> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public List<AppointmentEntity> getAppointmentsByDoctorId(Long doctorId){
        return appointmentRepository.findByDoctorId(doctorId);
    }

    public List<AppointmentEntity> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<AppointmentEntity> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public AppointmentEntity addAppointment(AppointmentEntity appointment) {
        return appointmentRepository.save(appointment);
    }

    public AppointmentEntity updateAppointment(Long id, AppointmentEntity appointmentDetails) {
        Optional<AppointmentEntity> existingAppointment = appointmentRepository.findById(id);
        if (existingAppointment.isPresent()) {
            AppointmentEntity appointment = existingAppointment.get();
            appointment.setAppointmentDate(appointmentDetails.getAppointmentDate());
            appointment.setId(appointmentDetails.getId());
            appointment.setId(appointmentDetails.getId());
            return appointmentRepository.save(appointment);
        }
        return null;
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
