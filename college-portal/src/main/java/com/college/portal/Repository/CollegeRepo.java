package com.college.portal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.portal.Model.College;


public interface CollegeRepo extends JpaRepository<College,Integer> {
    List<College> findByCollegeNameContaining(String name);
}
