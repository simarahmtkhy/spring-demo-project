package com.example.demo.course;

import com.example.demo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/course")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    @GetMapping(path = "{id}")
    public Course getCourse(@PathVariable("id") Long course_id){
        return this.courseService.getCourse(course_id);
    }

    @PostMapping
    public void addCourse(@RequestBody Course course){
        this.courseService.addCourse(course);
    }

    @PutMapping(path = "/{course_id}/students/{student_id}")
    public void addStudentToCourse(@PathVariable Long course_id, @PathVariable Long student_id){
        this.courseService.addStudentToCourse(course_id, student_id);
    }

    @PutMapping(path = "/{course_id}/teacher/{teacher_id}")
    public void assignTeacherToCourse(@PathVariable Long course_id, @PathVariable Long teacher_id){
        this.courseService.assignTeacher(course_id, teacher_id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteMapping(@PathVariable("id") Long course_id){
        this.courseService.deleteCourse(course_id);
    }
}
