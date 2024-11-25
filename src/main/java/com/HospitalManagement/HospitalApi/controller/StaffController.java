package com.HospitalManagement.HospitalApi.controller;

import com.HospitalManagement.HospitalApi.model.StaffEntity;
import com.HospitalManagement.HospitalApi.repository.StaffRepository;
import com.HospitalManagement.HospitalApi.service.StaffService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffRepository staffRepository;

    @GetMapping
    public List<StaffEntity> getAllStaff() {
        return staffRepository.findAll();
    }

    @GetMapping("/{id}")
    public StaffEntity getStaffById(@PathVariable Long id) {
        Optional<StaffEntity> staff = staffRepository.findById(id);
        return staff.orElse(null);
    }

    @PostMapping
    public StaffEntity createStaff(@RequestBody StaffEntity staff) {
        return staffRepository.save(staff);
    }

    @PutMapping("/{id}")
    public StaffEntity updateStaff(@PathVariable Long id, @RequestBody StaffEntity staffDetails) {
        Optional<StaffEntity> staffOptional = staffRepository.findById(id);
        if (staffOptional.isPresent()) {
            StaffEntity staff = staffOptional.get();
            staff.setName(staffDetails.getName());
            staff.setRole(staffDetails.getRole());
            return staffRepository.save(staff);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable Long id) {
        staffRepository.deleteById(id);
    }

    @Autowired
    private StaffService staffService;
    @GetMapping("/department/{departmentId}")
    public List<StaffEntity> getStaffIdsByDepartment(@PathVariable Long departmentId){
        return staffService.getStaffByDepartmentId(departmentId);
    }
}
