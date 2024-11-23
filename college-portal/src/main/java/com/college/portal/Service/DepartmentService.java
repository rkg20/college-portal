package com.college.portal.Service;


import com.college.portal.Model.Department;

public interface DepartmentService {
    public Department createDepartment(Integer collegeId,Department department);
    public Department updateDepartment(Integer collegeId,Department department,Integer departmentId);
    public  void deleteDepartment(Integer collegeId,Integer departmentId);

}
