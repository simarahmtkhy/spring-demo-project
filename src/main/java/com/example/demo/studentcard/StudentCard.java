package com.example.demo.studentcard;

import com.example.demo.student.Student;

import javax.persistence.*;

@Entity
@Table
public class StudentCard {
    @Id
    @SequenceGenerator(name = "card_id_generator", sequenceName = "card_id_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_id_generator")
    private Long studentCardID;

    @OneToOne()
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student owner;

    public StudentCard(Long studentCardID, Student owner) {
        this.studentCardID = studentCardID;
        this.owner = owner;
    }

    public StudentCard(Student owner) {
        this.owner = owner;
    }

    public StudentCard() {
    }

    public Long getStudentCardID() {
        return studentCardID;
    }

    public void setStudentCardID(Long studentCardID) {
        this.studentCardID = studentCardID;
    }

    public Student getOwner() {
        return owner;
    }

    public void setOwner(Student owner) {
        this.owner = owner;
    }


    @Override
    public String toString() {
        return "StudentCard{" +
                "studentCardID=" + studentCardID +
                ", owner=" + owner +
                '}';
    }
}
