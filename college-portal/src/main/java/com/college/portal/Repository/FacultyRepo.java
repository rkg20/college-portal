package com.college.portal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.portal.Model.Faculty;


public interface FacultyRepo extends JpaRepository<Faculty,Integer>{
    
}
