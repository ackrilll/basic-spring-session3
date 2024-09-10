package com.sparta.basicspringsession3.repository;

import com.sparta.basicspringsession3.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
