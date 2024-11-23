package com.college.portal.Service;

import com.college.portal.Model.Faculty;
import java.util.List;

public interface FacultyService {
    public Faculty createFaculty(Faculty faculty,Integer collegeId,Integer departmentId);
    public Faculty updateFaculty(Faculty faculty,Integer facultyId);
    public void deleteFaculty(Integer facultyId);
    public Faculty getFacultyById(Integer facultyId);
    public List<Faculty> getAllFaculty();
    public List<Faculty> getFacultyByCollegeId(Integer collegeId);


}
