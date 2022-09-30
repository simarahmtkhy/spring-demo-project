package com.example.demo.teacher;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {


    private final TeacherRepository repository;

    @Autowired
    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    public List<Teacher> getTeachers() {
        return this.repository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        this.repository.save(teacher);
    }

    public Teacher getTeacher(Long id) {
        return this.repository.findById(id).get();
    }

    public TeacherRepository getRepository() {
        return repository;
    }
}
