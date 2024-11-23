package com.college.portal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.portal.Model.Department;


public interface DepartmentRepo extends JpaRepository<Department,Integer> {
    
}
