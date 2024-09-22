package com.eedo.ZipTe.domain.repository;


import com.eedo.ZipTe.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MemberRepository extends JpaRepository<Member, String> {

}
