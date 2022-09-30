package com.example.demo.studentcard;

import com.example.demo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCardService {

    private final StudentCardRepository studentCardRepository;

    @Autowired
    public StudentCardService(StudentCardRepository studentCardRepository) {
        this.studentCardRepository = studentCardRepository;
    }

    public List<StudentCard> getStudentCards() {
        return this.studentCardRepository.findAll();
    }

    public StudentCard getStudentCard(Long sid) {
        if (this.studentCardRepository.findById(sid).isPresent()){
            return this.studentCardRepository.findById(sid).get();
        }
        else{
            throw new IllegalStateException("id card not found");
        }
    }

    public void addStudentCard(StudentCard s) {
        this.studentCardRepository.save(s);
    }

    public void deleteStudentCard(Long id) {
        if (this.studentCardRepository.findById(id).isPresent()){
            this.studentCardRepository.deleteById(id);
        }
        else{
            throw new IllegalStateException("id card not found");
        }
    }
}
