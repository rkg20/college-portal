package com.college.portal.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class College {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int collegeId;
    private String collegeName;

    @OneToMany(mappedBy="college",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnoreProperties("college")
    List<Department> departments=new ArrayList<>();

    @OneToMany(mappedBy="college",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnoreProperties("college")
    List<Faculty> faculties=new ArrayList<>();

    public College() {
    }
    public int getCollegeId() {
        return collegeId;
    }
    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }
    public String getCollegeName() {
        return collegeName;
    }
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
    public List<Department> getDepartments() {
        return departments;
    }
    public void setDepartments(List<Department> list) {
        this.departments = list;
    }
    public List<Faculty> getFaculties() {
        return faculties;
    }
    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }
    

    

}
