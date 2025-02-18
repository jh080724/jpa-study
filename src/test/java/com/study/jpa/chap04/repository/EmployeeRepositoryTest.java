package com.study.jpa.chap04.repository;

import com.study.jpa.chap04.entity.Department;
import com.study.jpa.chap04.entity.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Test
    void beforeInsert() {
        Department d1 = Department.builder()
                .name("영업부")
                .build();
        Department d2 = Department.builder()
                .name("개발부")
                .build();
        departmentRepository.save(d1);
        departmentRepository.save(d2);
        Employee e1 = Employee.builder()
                .name("라이옹")
                .department(d1)
                .build();
        Employee e2 = Employee.builder()
                .name("어피치")
                .department(d1)
                .build();
        Employee e3 = Employee.builder()
                .name("프로도")
                .department(d2)
                .build();
        Employee e4 = Employee.builder()
                .name("네오")
                .department(d2)
                .build();
        employeeRepository.save(e1);
        employeeRepository.save(e2);
        employeeRepository.save(e3);
        employeeRepository.save(e4);
    }

    @Test
    @DisplayName("특정 사원의 정보를 조회하면 그 사원의 부서 정보도 얻을 수 있다.")
    void testFindOne() {
        // given
        Long id = 2L;

        // when
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("사원이 존재하지 않음")
        );

        // then
        System.out.println("\n\n\n");
        System.out.println("[dbg] employee = " + employee);
        System.out.println("\n\n\n");

        assertEquals("어피치", employee.getName());
    }

    @Test
    @DisplayName("부서 정보 조회")
    void testFindDept() {
        // given
        Long id = 1L;

        // when
        Department department = departmentRepository.findById(id).orElseThrow();

        // then
        System.out.println("\n\n\n");
        System.out.println("[dbg] department = " + department);
        System.out.println("\n\n\n");

    }

}