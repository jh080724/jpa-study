package com.study.jpa.chap04.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString(exclude = {"department"})
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tbl_emp")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emp_id")
    private Long id;

    @Column(name="emp_name", nullable = false)
    private String name;

    // FetchType
    // EAGER: 해당 필드를 사용하든 말든 항상 무조건 조인을 수행
    // LAZY: 필요한 경우에만 데이터만 가져온다.  -> 실무에서는 LAZY만 쓴다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id") // FK 컬럼명(연관 테이블의 컬럼명과 일치해야함)
    private Department department;
}
