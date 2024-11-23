package com.college.portal.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.portal.Model.College;
import com.college.portal.Model.Department;
import com.college.portal.Model.Faculty;
import com.college.portal.Repository.CollegeRepo;
import com.college.portal.Repository.DepartmentRepo;
import com.college.portal.Repository.FacultyRepo;
import com.college.portal.Service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService{

    @Autowired
    private CollegeRepo collegeRepo;
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private FacultyRepo facultyRepo;

    @Override
    public Faculty createFaculty(Faculty faculty, Integer collegeId,Integer departmentId) {

        College college=this.collegeRepo.findById(collegeId).orElseThrow();
        Department department=this.departmentRepo.findById(departmentId).orElseThrow();

        faculty.setCollege(college);
        // faculty.setDepartment(department);
        Faculty savedFaculty =this.facultyRepo.save(faculty);
        return savedFaculty;

    }

    @Override
    public Faculty updateFaculty(Faculty faculty, Integer facultyId) {
        Faculty getFaculty=this.facultyRepo.findById(facultyId).orElseThrow();
        getFaculty.setFacultyName(faculty.getFacultyName());
        getFaculty.setFacultyEmailId(faculty.getFacultyEmailId());
        getFaculty.setFacultyContactNo(faculty.getFacultyContactNo());

        return this.facultyRepo.save(getFaculty);
    }

    @Override
    public void deleteFaculty(Integer facultyId) {
        Faculty faculty=this.facultyRepo.findById(facultyId).orElseThrow();
        this.facultyRepo.delete(faculty);
    }

    @Override
    public Faculty getFacultyById(Integer facultyId) {
        Faculty faculty=this.facultyRepo.findById(facultyId).orElseThrow();
        return faculty;
    }

    @Override
    public List<Faculty> getAllFaculty() {
        return this.facultyRepo.findAll();
    }

    @Override
    public List<Faculty> getFacultyByCollegeId(Integer collegeId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFacultyByCollegeId'");
    }
    
}
