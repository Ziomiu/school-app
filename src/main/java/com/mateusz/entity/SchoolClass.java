package com.mateusz.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "school_class")
public class SchoolClass
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "profile")
    private String profile;

    @Column(name = "teacherId")
    private Integer teacherId;
    
    @OneToMany(mappedBy = "schoolClass")
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents()
    {
        return students;
    }
    public void setStudents(List<Student> students)
    {
        this.students = students;
    }
    public Integer getTeacherId()
    {
        return teacherId;
    }
    public void setTeacherId(Integer teacherId)
    {
        this.teacherId = teacherId;
    }
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getProfile()
    {
        return profile;
    }

    public void setProfile(String profile)
    {
        this.profile = profile;
    }

}