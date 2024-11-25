//package com.HospitalManagement.HospitalApi.service;
//
//
//
//import com.HospitalManagement.HospitalApi.model.DepartmentEntity;
//import com.HospitalManagement.HospitalApi.repository.DepartmentRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class DepartmentService {
//
//    @Autowired
//    private DepartmentRepository departmentRepository;
//
//    public List<DepartmentEntity> getAllDepartments() {
//        return departmentRepository.findAll();
//    }
//
//    public Optional<DepartmentEntity> getDepartmentById(Long id) {
//        return departmentRepository.findById(id);
//    }
//
//    public DepartmentEntity addDepartment(DepartmentEntity department) {
//        return departmentRepository.save(department);
//    }
//
//    public DepartmentEntity updateDepartment(Long id, DepartmentEntity departmentDetails) {
//        Optional<DepartmentEntity> existingDepartment = departmentRepository.findById(id);
//        if (existingDepartment.isPresent()) {
//            DepartmentEntity department = existingDepartment.get();
//            department.setName(departmentDetails.getName());
//            return departmentRepository.save(department);
//        }
//        return null;
//    }
//
//    public void deleteDepartment(Long id) {
//        departmentRepository.deleteById(id);
//    }
//}
package com.HospitalManagement.HospitalApi.service;

import com.HospitalManagement.HospitalApi.model.DepartmentEntity;
import com.HospitalManagement.HospitalApi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentEntity> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<DepartmentEntity> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public DepartmentEntity addDepartment(DepartmentEntity department) {
        return departmentRepository.save(department);
    }

    public DepartmentEntity updateDepartment(Long id, DepartmentEntity departmentDetails) {
        Optional<DepartmentEntity> existingDepartment = departmentRepository.findById(id);
        if (existingDepartment.isPresent()) {
            DepartmentEntity department = existingDepartment.get();
            department.setName(departmentDetails.getName());
            return departmentRepository.save(department);
        }
        return null;
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
