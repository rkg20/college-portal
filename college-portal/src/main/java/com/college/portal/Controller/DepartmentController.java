package com.college.portal.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.portal.Model.Department;
import com.college.portal.Repository.DepartmentRepo;
import com.college.portal.Service.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/college/{collegeId}/department")
    public ResponseEntity<Department> createDepartment(@PathVariable Integer collegeId,@RequestBody Department department){
        Department createdDepartment=this.departmentService.createDepartment(collegeId,department);
        return new ResponseEntity<Department>(createdDepartment,HttpStatus.CREATED);
    }
    
    
    @PutMapping("/college/{collegeId}/department/{departmentId}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Integer collegeId,@PathVariable Integer departmentId,@RequestBody Department department){
        Department updatedDepartment=this.departmentService.updateDepartment(collegeId, department, departmentId);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("/college/{collegeId}/department/{departmentId}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Integer collegeId,@PathVariable Integer departmentId ){
        this.departmentService.deleteDepartment(collegeId,departmentId);
        return new ResponseEntity(Map.of("message","Department Deleted Successfully"),HttpStatus.OK);
    }

   
}
