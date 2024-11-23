package com.college.portal.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.portal.Model.College;
import com.college.portal.Service.CollegeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @PostMapping("/college")
    public ResponseEntity<College> createCollege(@RequestBody College College){
        College createdCollege=this.collegeService.createCollege(College);
        return new ResponseEntity<>(createdCollege,HttpStatus.CREATED);
    }

    @PutMapping("/college/{collegeId}")
    public ResponseEntity<College> updateCollege(@RequestBody College college,@PathVariable Integer collegeId){
        College updatedCollege=this.collegeService.updateCollege(college, collegeId);
        return ResponseEntity.ok(updatedCollege);
    }

    @DeleteMapping("/college/{collegeId}")
    public ResponseEntity<?> deleteCollege(@PathVariable Integer collegeId){
        this.collegeService.deleteCollege(collegeId);
        return new ResponseEntity(Map.of("message","College Deleted Successfully"),HttpStatus.OK);
    }

    @GetMapping("/college/{collegeId}")    
    public ResponseEntity<College> getCollegeById(@PathVariable Integer collegeId){
        System.out.println(collegeId);
        College college=this.collegeService.getCollegeById(collegeId);
        return ResponseEntity.ok(college);
        
    }
    @GetMapping("/college/search/{name}")
    public ResponseEntity<List<College>> searchCollegeByCollegeName(@PathVariable String name){
        List<College> colleges=this.collegeService.searchCollege(name);
        // List<College> colleges=null;
        // System.out.println(name+" : "+name.length());
        return ResponseEntity.ok(colleges);
    }

    @GetMapping("/colleges")
    public ResponseEntity<List<College>> getAllCollege(){
        List<College> colleges=this.collegeService.getAllCollege();
        return ResponseEntity.ok(colleges);
    }

    

}
