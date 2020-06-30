package com.mateusz.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.mateusz.entity.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer>
{
    ArrayList<Teacher> findByName(String name);
    
    
}