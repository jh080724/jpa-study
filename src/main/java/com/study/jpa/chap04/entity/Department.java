package com.study.jpa.chap04.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString(exclude = {"employees"})
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tbl_dept")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dept_id")
    private Long id;    // 부서번호

    @Column(name="dept_name", nullable = false)
    private String name;

    // 양방향 맵핑에서는 실제 테이블에 List가 세팅되지 않는다.
    // 엔터티 안에서만 사용하는 가상의 컬럼임.
    // 상대방 엔터티의 갱신에 관여할 수 없기때문에 단순히 읽기전용(조회)으로만 사용하는 것을 권장
    @OneToMany(mappedBy = "department")  // 연관관계 Entity의 필드명을 mappedBy에 명시해줘야함. Employee 객체의 필드명 private Department department;
    private List<Employee> employees;
}
