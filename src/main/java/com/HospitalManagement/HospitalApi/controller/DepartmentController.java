//package com.HospitalManagement.HospitalApi.controller;
//
//import com.HospitalManagement.HospitalApi.model.DepartmentEntity;
//import com.HospitalManagement.HospitalApi.repository.DepartmentRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/departments")
//public class DepartmentController {
//
//    @Autowired
//    private DepartmentRepository departmentRepository;
//
//    @GetMapping
//    public List<DepartmentEntity> getAllDepartments() {
//        return departmentRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public DepartmentEntity getDepartmentById(@PathVariable Long id) {
//        Optional<DepartmentEntity> department = departmentRepository.findById(id);
//        return department.orElse(null);
//    }
//
//    @PostMapping
//    public DepartmentEntity createDepartment(@RequestBody DepartmentEntity department) {
//        return departmentRepository.save(department);
//    }
//
//    @PutMapping("/{id}")
//    public DepartmentEntity updateDepartment(@PathVariable Long id, @RequestBody DepartmentEntity departmentDetails) {
//        Optional<DepartmentEntity> departmentOptional = departmentRepository.findById(id);
//        if (departmentOptional.isPresent()) {
//            DepartmentEntity department = departmentOptional.get();
//            department.setName(departmentDetails.getName());
//            return departmentRepository.save(department);
//        }
//        return null;
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteDepartment(@PathVariable Long id) {
//        departmentRepository.deleteById(id);
//    }
//}
//
package com.HospitalManagement.HospitalApi.controller;

import com.HospitalManagement.HospitalApi.model.DepartmentEntity;
import com.HospitalManagement.HospitalApi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<DepartmentEntity> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public DepartmentEntity getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id).orElse(null);
    }

    @PostMapping
    public DepartmentEntity createDepartment(@RequestBody DepartmentEntity department) {
        return departmentService.addDepartment(department);
    }

    @PutMapping("/{id}")
    public DepartmentEntity updateDepartment(@PathVariable Long id, @RequestBody DepartmentEntity departmentDetails) {
        return departmentService.updateDepartment(id, departmentDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }
}

