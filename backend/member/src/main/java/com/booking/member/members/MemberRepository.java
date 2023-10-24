package com.booking.member.members;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {
    Member findByEmail(String email);

    boolean existsByEmail(String email);
}
