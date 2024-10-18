package com.study.jpa.chap05.repositoty;

import com.study.jpa.chap05.entity.Idol;

import java.util.List;
import java.util.Optional;

// 쿼리 DSL 레파지토리로 사용할 것. (JPA 상속 안받음)
public interface IdolCustomRepository {

    // 이름으로 오름차정렬해서 전체 조회(쿼리 메소드 아님... 혼돈 금지)
    List<Idol> findAllSortedByName();

    // 그룸명으로 아이돌 조회
    Optional<List<Idol>> findByGroupName(String groupName);
}
