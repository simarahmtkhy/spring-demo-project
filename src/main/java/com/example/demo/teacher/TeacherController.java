package com.example.demo.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getTeachers(){
        return this.teacherService.getTeachers();
    }

    @PostMapping
    public void addTeacher(@RequestBody Teacher teacher){
        this.teacherService.addTeacher(teacher);
    }

    @GetMapping(path = "/{id}")
    public Teacher getTeacher(@PathVariable Long id){
        return this.teacherService.getTeacher(id);
    }


}
