package com.study.jpa.chap01.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
@EqualsAndHashCode(of = "id")  // id 필드만 비교해서 같은면 같은 객체로 판단 Lombok
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity // JPA 어노테이션
@Table(name = "tbl_product") // table 이름을 지정, 지정안하면 클래스 이름으로 지정
public class Product {

    @Id // Primary Key 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncrement 지정
    @Column(name="prod_id") // 컬럼명 지정
    private Long id;

    @Column(name="prod_nm", length = 30, nullable = false) // 컬럼명 지정 + 컬럼 속성 지정
    private String name;

    @Column(name="prod_price")
    private int price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING) // Enum 타입 지정
    private Category category;

    @CreationTimestamp  // INSERT 시에 자동으로 서버시간 저장
    @Column(updatable = false)  // 1번 세팅되면 수정불가
    private LocalDateTime createAt;

    @UpdateTimestamp    // UPDATE 문 실행 시 자동으로 시간이 저장
    private LocalDateTime updateAt;

    @Transient  // 데이터베이스에는 저장안하고 클래스 내부에서만 사용할 필드(테이블 매핑에서는 제외)
    private String nickname;

    public enum Category {
        FOOD, FASHION, ELECTRONIC
    }
}
