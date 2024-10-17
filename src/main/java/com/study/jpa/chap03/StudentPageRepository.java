package com.study.jpa.chap03;

import com.study.jpa.chap02.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentPageRepository extends JpaRepository<Student, String> {
    Page<Student> findByNameContaining(String name, Pageable pageable);
}
