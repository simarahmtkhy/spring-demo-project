package com.example.demo.studentcard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCardRepository extends JpaRepository<StudentCard, Long> {
}
