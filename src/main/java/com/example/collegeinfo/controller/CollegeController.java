package com.example.collegeinfo.controller;

import com.example.collegeinfo.entity.College;
import com.example.collegeinfo.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CollegeController {
    @Autowired
    private CollegeService service;

    @PostMapping("/addCollege")
    public College addCollege(@RequestBody College college){
        return service.saveCollege(college);
    }
    @PostMapping("/addColleges")
    public List<College> addColleges(@RequestBody List<College> colleges){
        return service.saveCollege(colleges);
    }

    @GetMapping("/colleges")
    public List<College> findAllColleges(){
        return service.getColleges();
    }

    @GetMapping("/college/{name}")
    public College findCollegeByName(@PathVariable String name){
        return service.getCollegeByName(name);
    }

    @DeleteMapping("/delete/{name}")
    public String deleteCollege(@PathVariable String name){
        return service.deleteCollegeByName(name);
    }
}
