package com.HospitalManagement.HospitalApi.model;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DoctorEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctor_id;

    @NonNull
    private String name;

    @NonNull
    private String specialization;

    private double experience;
    private Long contact;

    public DoctorEntity(){
        
    }

    public DoctorEntity(String name, String specialization, double experience, Long contact){
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
        this.contact = contact;
    }

    public Long getId() {
        return doctor_id;
    }

    public void setId(Long id) {
        this.doctor_id = id;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public double getExperience(){
        return experience;
    }

    public void setExperience(double experience){
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() { 
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}