package com.example.collegeinfo.service;

import com.example.collegeinfo.entity.College;
import com.example.collegeinfo.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {
    @Autowired
    private CollegeRepository repository;

    public College saveCollege(College college){ // save college
       return repository.save(college);
    }

    public List<College> saveCollege(List<College> college){ // save list of colleges
        return repository.saveAll(college);
    }

    public List<College> getColleges(){  // get list of all colleges
        return repository.findAll();
    }

    public College getCollegeByName(String name){ // get by name
        return repository.findByName(name);
    }

    public String deleteCollegeByName(String name){
        repository.deleteByName(name);
        return "College removed"+name;
    }

    public College updateCollege(College college){
        College existsCollege=repository.findById(Math.toIntExact(college.getId())).orElse(null);
        existsCollege.setName(college.getName());
        existsCollege.setDescription(college.getDescription());

        return repository.save(existsCollege);
    }
}
