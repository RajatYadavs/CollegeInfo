package com.example.collegeinfo.repository;

import com.example.collegeinfo.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College,Integer> {
    College findByName(String name);

    void deleteByName(String name);
}
