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

import com.college.portal.Model.Faculty;
import com.college.portal.Service.FacultyService;

@RestController
@RequestMapping("/api")
public class FacultyController {
    
    @Autowired
    private FacultyService facultyService;

    @PostMapping("/college/{collegeId}/department/{departmentId}/faculty")
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty,@PathVariable Integer collegeId,@PathVariable Integer departmentId){

        Faculty createdFaculty=this.facultyService.createFaculty(faculty, collegeId,departmentId);
        return new ResponseEntity<>(createdFaculty,HttpStatus.CREATED);
    }

    @PutMapping("/faculty/{facultyId}")
    public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty,@PathVariable Integer facultyId){

        Faculty updatedFaculty=this.facultyService.updateFaculty(faculty,facultyId);
        return ResponseEntity.ok(updatedFaculty);
    }

    @DeleteMapping("/faculty/{facultyId}")
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable Integer facultyId){

        this.facultyService.deleteFaculty(facultyId);
        return new ResponseEntity(Map.of("message","Faculty Deleted Sucessfully"),HttpStatus.OK);
    }
    // @GetMapping("/faculty/{facultyId}")
    // public ResponseEntity<Faculty> getFacultyById(@PathVariable Integer facultyId){
    //     Faculty faculty=this.facultyService.getFacultyById(facultyId);
    //     return ResponseEntity.ok(faculty);
    // }

    @GetMapping("/faculty")
    public ResponseEntity<List<Faculty>> getAllFaculty(){
        List<Faculty> faculties=this.facultyService.getAllFaculty();
        return ResponseEntity.ok(faculties);
    }

    // public ResponseEntity<Faculty> getFacultyByCollegeId(@PathVariable Integer collegeId){

        


    //     return null;
    // }
    
}
