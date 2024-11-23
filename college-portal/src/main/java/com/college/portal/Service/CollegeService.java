package com.college.portal.Service;

import java.util.List;


import com.college.portal.Model.College;


public interface CollegeService {
    public College createCollege(College college);
    public College updateCollege(College college,Integer collegeId);
    public void deleteCollege(Integer collegeId);
    public College getCollegeById(Integer collegeId);
    public List<College> searchCollege(String keywords);
    public List<College> getAllCollege();

}
