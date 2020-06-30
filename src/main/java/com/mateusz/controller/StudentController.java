package com.mateusz.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mateusz.entity.Student;
import com.mateusz.repository.SchoolClassRepository;
import com.mateusz.repository.StudentRepository;

@Controller
@RequestMapping("/students/")
public class StudentController
{
    private final StudentRepository studentRepository;
    private final SchoolClassRepository schoolClassRepository;
    
    @Autowired
    public StudentController( StudentRepository studentRepository, SchoolClassRepository schoolClassRepository)
    {
        this.studentRepository = studentRepository;
        this.schoolClassRepository =  schoolClassRepository;
    }
    
    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("students" , studentRepository.findAll() );
        return "index";
    }
    
    
    @GetMapping("create")
    public String showAddStudentForm(Student student, Model model) {
        model.addAttribute("schoolClasses", schoolClassRepository.findAll());
        return "add-students";
    }
    
    @PostMapping("add")
    public String addStudent(@Valid Student student, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "add-students";
        }
        
        studentRepository.save(student);
        return "redirect:list";
    }
    
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Student student = studentRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid Student ID:" + id));
        model.addAttribute("student" , student);
        model.addAttribute("schoolClasses", schoolClassRepository.findAll());
        return "update-student";
    }
    @PostMapping("update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, @Valid Student student, BindingResult result, Model model) {
        if(result.hasErrors()) {
            student.setId(id);
            return "update-student";
            
        }
            
            studentRepository.save(student);
            
            return showUpdateForm(model);

        
        
  }
    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id, Model model) {
        Student student = studentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid Student ID:" + id));
            
        
        studentRepository.delete(student);
        return showUpdateForm(model);
    }
}
