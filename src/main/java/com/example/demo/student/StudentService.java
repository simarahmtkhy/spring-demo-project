package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        System.out.println(studentRepository.findAll());
        return studentRepository.findAll();
    }

    public void addStudent(Student s) {
        Optional<Student> optionalStudent = studentRepository.findStudentByEmail(s.getEmail());
        if (optionalStudent.isPresent()){
            throw new IllegalStateException("email available");
        }
        else {
            studentRepository.save(s);
        }


    }

    public void deleteStudent(Long studentId) {
        if (studentRepository.findById(studentId).isPresent()){
            studentRepository.delete(studentRepository.findById(studentId).get());
        }
        else {
            throw new IllegalStateException("student not found");
        }


    }

    public Student getStudent(Long sid) {
        if (studentRepository.findById(sid).isPresent()){
            return studentRepository.findById(sid).get();
        }
        else {
            throw new IllegalStateException("Student not found");
        }
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }
}
