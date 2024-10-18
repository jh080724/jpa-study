package com.study.jpa.chap04.repository;

import com.study.jpa.chap04.entity.Department;
import com.study.jpa.chap04.entity.Employee;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class DepartmentRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EntityManager em;

    @Test
    @DisplayName("부서 정보 조회하면 해당 부서원들도 함께 조회된다.")
    void testFindDept() {
        // given
        Long id = 1L;

        // when
        Department department = departmentRepository.findById(id).orElseThrow();

        // then
        System.out.println("\n\n\n");
        System.out.println("[dbg] department = " + department);
        System.out.println("[dbg] department.getEmployees() = " + department.getEmployees());
        System.out.println("\n\n\n");

    }

    @Test
    @DisplayName(".")
    void testMethod() {
        //3번 사원을 조회하고 싶은데, 굳이 부서정보까지는 필요없음.
        // given
        Long id = 3L;

        // when
        Employee employee = employeeRepository.findById(id).orElseThrow();

        // then
        System.out.println("\n\n\n");
        System.out.println("employee = " + employee);
        System.out.println("\n\n\n");

    }

    @Test
    @DisplayName("양방향 연관관계에서 연관 데이터의 수정")
    void testChangeDept() {
        // 1사원의 부서를 1 -> 2번 부서로 변경해야 한다.

        // given
        Employee foundEmp = employeeRepository.findById(1L).orElseThrow();

        Department newDept = departmentRepository.findById(2L).orElseThrow();

//        foundEmp.setDepartment(newDept);
//
        // 연관관계 편의 메서드 호출 -> 데이터 수정시에는 반대편 엔터티도 꼭 수정을 해야한다.
        foundEmp.changeDepartment(newDept);

//        employeeRepository.save(foundEmp);
//        newDept.getEmployees().add(foundEmp);

//        em.flush(); // DB로 밀어내기
//        em.clear(); // 영속성 컨텍스트 비우기(비우지 않음, 컨텍스트 내의 정보를 참조하려 하니까)

        // when
//        Department foundDept = departmentRepository.findById(2L).orElseThrow();

        // then
        System.out.println("---------------------------------------\n\n\n");
//        foundDept.getEmployees().forEach(emp-> System.out.println(emp));
        newDept.getEmployees().forEach(emp-> System.out.println(emp));
        System.out.println("---------------------------------------\n\n\n");

    }
}