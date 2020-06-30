package com.mateusz.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.mateusz.entity.SchoolClass;

@Repository
public interface SchoolClassRepository extends CrudRepository<SchoolClass, Integer>
{
    ArrayList<SchoolClass> findByName(String name);
    
    
}