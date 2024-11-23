package com.college.portal.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.portal.Exception.ResourceNotFoundException;
import com.college.portal.Model.College;
import com.college.portal.Model.Department;
import com.college.portal.Repository.CollegeRepo;
import com.college.portal.Service.CollegeService;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeRepo collegeRepo;

    @Override
    public College createCollege(College college) {
        return this.collegeRepo.save(college);
        
    }

    @Override
    public College updateCollege(College college, Integer collegeId) {
        College getCollege=this.collegeRepo.findById(collegeId).orElseThrow();
        getCollege.setCollegeName(college.getCollegeName());
        this.collegeRepo.save(getCollege);
        return getCollege;
    }

    @Override
    public void deleteCollege(Integer collegeId) {
       College college= this.collegeRepo.findById(collegeId).orElseThrow();
       this.collegeRepo.delete(college);
    }

    @Override
    public College getCollegeById(Integer collegeId) {
        College college=this.collegeRepo.findById(collegeId).orElseThrow(()->new ResourceNotFoundException("College", "Id", collegeId));
        List<Department> departments=college.getDepartments();
        college.setDepartments(departments);
        // for (Department department : departments) {
        //     System.out.println(department.getDepartmentId()+" "+department.getDepartmentName());
        // }
        
        return college;
    }

    @Override
    public List<College> searchCollege(String name) {
        List<College> colleges=this.collegeRepo.findByCollegeNameContaining(name);
        return colleges;
    }

    @Override
    public List<College> getAllCollege() {

          return this.collegeRepo.findAll();
    }
    
}
