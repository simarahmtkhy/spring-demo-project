package com.example.demo.course;


import com.example.demo.student.StudentService;
import com.example.demo.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    private final StudentService studentService;

    private final TeacherService teacherService;


    @Autowired
    public CourseService(CourseRepository courseRepository, StudentService studentService, TeacherService teacherService) {
        this.courseRepository= courseRepository;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }


    public List<Course> getCourses() {
        return this.courseRepository.findAll();
    }

    public Course getCourse(Long course_id) {
        if (this.courseRepository.findById(course_id).isPresent()){
            return this.courseRepository.findById(course_id).get();
        }
        else {
            throw new IllegalStateException("no such course");
        }
    }

    public void addCourse(Course course) {
        this.courseRepository.save(course);
    }

    public void deleteCourse(Long course_id) {
        if (this.courseRepository.findById(course_id).isPresent()){
            this.courseRepository.deleteById(course_id);
        }
        else {
            throw new IllegalStateException("no such course");
        }
    }

    public void addStudentToCourse(Long course_id, Long student_id) {
        if (!this.courseRepository.findById(course_id).isPresent()){
            throw new IllegalStateException("no such course");
        } else if (!this.studentService.getStudentRepository().findById(student_id).isPresent()) {
            throw new IllegalStateException("no such student");
        }
        else {
            this.getCourse(course_id).addStudent(this.studentService.getStudent(student_id));
            this.courseRepository.save(courseRepository.findById(course_id).get());
        }
    }

    public void assignTeacher(Long course_id, Long teacher_id) {
        if (!this.courseRepository.findById(course_id).isPresent()){
            throw new IllegalStateException("no such course");
        } else if (!this.teacherService.getRepository().findById(teacher_id).isPresent()) {
            throw new IllegalStateException("no such teacher");
        }
        else {
            this.getCourse(course_id).setTeacher(this.teacherService.getTeacher(teacher_id));
            this.courseRepository.save(courseRepository.findById(course_id).get());
        }
    }
}
