package com.college.portal.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int departmentId;
    private String departmentName;
    
    @ManyToOne
    @JoinColumn(name = "college_id")
    College college;

    // @OneToMany(mappedBy = "department",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    // List<Faculty> faculties=new ArrayList<>();
   
    public Department() {
    }
    public Department(int departmentId, String departmentName, College college, List<Faculty> faculties) {
    this.departmentId = departmentId;
    this.departmentName = departmentName;
    this.college = college;
    // this.faculties = faculties;
    }
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
    // public List<Faculty> getFaculties() {
    //     return faculties;
    // }
    // public void setFaculties(List<Faculty> faculties) {
    //     this.faculties = faculties;
    // }

    
    
    


}
