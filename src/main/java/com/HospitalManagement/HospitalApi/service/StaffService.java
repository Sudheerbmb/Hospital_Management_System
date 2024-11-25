package com.HospitalManagement.HospitalApi.service;


import com.HospitalManagement.HospitalApi.model.StaffEntity;
import com.HospitalManagement.HospitalApi.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public List<StaffEntity> getAllStaff() {
        return staffRepository.findAll();
    }

    public Optional<StaffEntity> getStaffById(Long id) {
        return staffRepository.findById(id);
    }

    
    public StaffEntity addStaff(StaffEntity staff) {
        return staffRepository.save(staff);
    }

    public StaffEntity updateStaff(Long id, StaffEntity staffDetails) {
        Optional<StaffEntity> existingStaff = staffRepository.findById(id);
        if (existingStaff.isPresent()) {
            StaffEntity staff = existingStaff.get();
            staff.setName(staffDetails.getName());
            staff.setRole(staffDetails.getRole());
            return staffRepository.save(staff);
        }
        return null;
    }

    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }

    public List<StaffEntity> getStaffByDepartmentId(Long departmentId){
        return staffRepository.findByDepartmentId(departmentId);
    }
}

