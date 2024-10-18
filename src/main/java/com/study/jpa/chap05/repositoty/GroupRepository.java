package com.study.jpa.chap05.repositoty;

import com.study.jpa.chap05.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {

}
