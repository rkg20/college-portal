package com.college.portal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.college.portal.Model.College;
import com.college.portal.Model.Department;
import com.college.portal.Model.Faculty;
import com.college.portal.Repository.CollegeRepo;
import com.college.portal.Repository.DepartmentRepo;

@SpringBootApplication
public class CollegePortalApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CollegePortalApplication.class, args);
		System.out.println("Welcome to College Portal");
	}

	@Override
	public void run(String... args) throws Exception {

		/* 
		College college=collegeRepo.findById(3).orElseThrow();
		System.out.println(college.getCollegeId()+" "+college.getCollegeName());
		List<Department> departments=college.getDepartments();

		for (Department department : departments) {
			System.out.println(department.getDepartmentId()+" "+department.getDepartmentName());
		}


		List<Department> departmentList=this.departmentRepo.findAll();
		for (Department department : departmentList) {
			System.out.println(department.getDepartmentId()+" "+department.getDepartmentName());
		}
		*/

		// College college =collegeRepo.findById(1).orElseThrow();
		// List<Faculty> faculties=college.getFaculties();
		// for(Faculty faculty:faculties){
		// 	System.out.println(faculty.getFacultyId()+" "+faculty.getFacultyName()+faculty.getFacultyEmailId()+faculty.getDepartment().getDepartmentName());
		// }
	}

	@Autowired
	private CollegeRepo collegeRepo;

	@Autowired
	private DepartmentRepo departmentRepo;

}
