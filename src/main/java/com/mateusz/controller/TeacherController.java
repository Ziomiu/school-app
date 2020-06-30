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

import com.mateusz.entity.Teacher;
import com.mateusz.repository.TeacherRepository;

@Controller
@RequestMapping("/teachers/")
public class TeacherController
{
    private final TeacherRepository studentRepository;
    
    @Autowired
    public TeacherController( TeacherRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }
    
    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("teachers" , studentRepository.findAll() );
        return "indexT";
    }
    
    @GetMapping("create")
    public String showAddTeacherForm(Teacher teacher) {
        return "add-teachers";
    }
    
    @PostMapping("add")
    public String addTeacher(@Valid Teacher teacher, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "add-teachers";
        }
        
        studentRepository.save(teacher);
        return "redirect:list";
    }
    
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Teacher teacher = studentRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid Teacher ID:" + id));
        model.addAttribute("teacher" , teacher);
        return "update-teacher";
    }
    @PostMapping("update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, @Valid Teacher teacher, BindingResult result, Model model) {
        if(result.hasErrors()) {
            teacher.setId(id);
            return "update-teacher";
        }
            
            studentRepository.save(teacher);
            
            return showUpdateForm(model);

        
        
  }
    @GetMapping("deleteT/{id}")
    public String deleteTeacher(@PathVariable("id") Integer id, Model model) {
        Teacher teacher = studentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid Teacher ID:" + id));
            
        
        studentRepository.delete(teacher);
        return showUpdateForm(model);
    }
}
