package com.college.portal.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.portal.Exception.ResourceNotFoundException;
import com.college.portal.Model.College;
import com.college.portal.Model.Department;
import com.college.portal.Repository.CollegeRepo;
import com.college.portal.Repository.DepartmentRepo;
import com.college.portal.Service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private CollegeRepo collegeRepo;
    @Autowired
    private DepartmentRepo departmentRepo;


    @Override
    public Department createDepartment(Integer collegeId, Department department) {
        College college=this.collegeRepo.findById(collegeId).orElseThrow(()->new ResourceNotFoundException("College", "Id", collegeId));
        department.setCollege(college);

        // List<Department> list=college.getDepartments();
        // college.setDepartments(list);
        // System.out.println(department.getDepartmentId()+" "+department.getDepartmentName());
        Department savedDepartment=this.departmentRepo.save(department);
        return savedDepartment;
    }

    @Override
    public Department updateDepartment(Integer collegeId, Department department, Integer departmentId) {
        College college=this.collegeRepo.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("College", "Id", collegeId));

        Department getDepartment=this.departmentRepo.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("Department", "Id", departmentId));
        // getDepartment.setDepartmentId(department.getDepartmentId());
        getDepartment.setDepartmentName(department.getDepartmentName());
        // getDepartment.setCollege(college);
        return this.departmentRepo.save(getDepartment);
        
    }

    @Override
    public void deleteDepartment(Integer collegeId,Integer departmentId) {
        Department department=this.departmentRepo.findById(departmentId).orElseThrow(()-> new ResourceNotFoundException("Department", "Id", departmentId));
        System.out.println(department.getDepartmentId()+" "+department.getDepartmentName());
        this.departmentRepo.delete(department);

    }

    
}
