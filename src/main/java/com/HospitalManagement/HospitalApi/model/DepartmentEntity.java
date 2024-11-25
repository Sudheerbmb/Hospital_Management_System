//package com.HospitalManagement.HospitalApi.model;
//
//import java.util.List;
//
//import io.micrometer.common.lang.NonNull;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//
//@Entity
//public class DepartmentEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long department_id;
//
//    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
//    private List<StaffEntity> staff;
//
//    @NonNull
//    private String name;
//
//    public DepartmentEntity(){
//
//    }
//
//    public DepartmentEntity(String name) {
//        this.name = name;
//    }
//
//    public Long getId() {
//        return department_id;
//    }
//
//    public void setId(Long id) {
//        this.department_id = id;
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
//    public List<StaffEntity> getStaff() {
//        return staff;
//    }
//
//    public void setStaff(List<StaffEntity> staff) {
//        this.staff = staff;
//    }
//}


package com.HospitalManagement.HospitalApi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long department_id;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    @JsonManagedReference // Avoid infinite recursion by serializing this side of the relationship
    private List<StaffEntity> staff;

    @NonNull
    private String name;

    public DepartmentEntity() {
    }

    public DepartmentEntity(String name) {
        this.name = name;
    }

    public Long getId() {
        return department_id;
    }

    public void setId(Long id) {
        this.department_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StaffEntity> getStaff() {
        return staff;
    }

    public void setStaff(List<StaffEntity> staff) {
        this.staff = staff;
    }
}

