//package com.HospitalManagement.HospitalApi.model;
//
//import io.micrometer.common.lang.NonNull;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//
//@Entity
//public class StaffEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long staff_id;
//
//    @ManyToOne
//    @JoinColumn(name = "department_id", nullable = false)
//    private DepartmentEntity department;
//
//    @NonNull
//    private String name;
//
//    @NonNull
//    private String role;
//
//
//    public StaffEntity(){
//
//    }
//    // Constructor
//    public StaffEntity(String name, String role, DepartmentEntity department) {
//        this.name = name;
//        this.role = role;
//        this.department = department;
//    }
//
//    // Getters and Setters
//    public Long getId() {
//        return staff_id;
//    }
//
//    public void setId(Long id) {
//        this.staff_id = id;
//    }
//
//    public DepartmentEntity getDepartment(){
//        return department;
//    }
//    public void setDepartment(DepartmentEntity department){
//        this.department = department;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//}
package com.HospitalManagement.HospitalApi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class StaffEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staff_id;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    @JsonBackReference // Prevent infinite recursion by not serializing this side of the relationship
    private DepartmentEntity department;

    @NonNull
    private String name;

    @NonNull
    private String role;

    public StaffEntity() {
    }

    // Constructor
    public StaffEntity(String name, String role, DepartmentEntity department) {
        this.name = name;
        this.role = role;
        this.department = department;
    }

    // Getters and Setters
    public Long getId() {
        return staff_id;
    }

    public void setId(Long id) {
        this.staff_id = id;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
