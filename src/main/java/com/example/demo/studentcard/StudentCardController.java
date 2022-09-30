package com.example.demo.studentcard;

import com.example.demo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/studentcard")
public class StudentCardController {

    private final StudentCardService studentCardService;

    @Autowired
    public StudentCardController(StudentCardService studentCardService) {
        this.studentCardService = studentCardService;
    }

    @GetMapping
    public List<StudentCard> getStudentCards(){
        return this.studentCardService.getStudentCards();
    }

    @GetMapping(path = "{id}")
    public StudentCard getStudent(@PathVariable("id") Long sid){
        StudentCard studentCard = studentCardService.getStudentCard(sid);
        System.out.println(studentCard.getOwner().getName());
        return studentCard;
    }

    @PostMapping
    public void addStudent(@RequestBody StudentCard s){
        studentCardService.addStudentCard(s);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        studentCardService.deleteStudentCard(id);
    }
}
