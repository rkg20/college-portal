package com.college.portal.Model;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Faculty {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int facultyId;
    private String facultyName;
    private String facultyEmailId;
    private long facultyContactNo;
    
    @ManyToOne
    @JoinColumn(name = "college_id")
    College college;
    
    // @ManyToOne
    // @JoinColumn(name = "department_id")
    // @JsonManagedReference
    // Department department;

    public Faculty() {
    }

    public Faculty(int facultyId, String facultyName, String facultyEmailId, long facultyContactNo, College college ) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyEmailId = facultyEmailId;
        this.facultyContactNo = facultyContactNo;
        this.college = college;
    }




    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyEmailId() {
        return facultyEmailId;
    }

    public void setFacultyEmailId(String facultyEmailId) {
        this.facultyEmailId = facultyEmailId;
    }

    public long getFacultyContactNo() {
        return facultyContactNo;
    }
    public void setFacultyContactNo(long facultyContactNo) {
        this.facultyContactNo = facultyContactNo;
    }
    public College getCollege() {
        return college;
    }
    public void setCollege(College college) {
        this.college = college;
    }
    // public Department getDepartment() {
    //     return department;
    // }

    // public void setDepartment(Department department) {
    //     this.department = department;
    // }
    

    
    

}
