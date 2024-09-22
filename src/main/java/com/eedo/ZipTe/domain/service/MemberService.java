package com.eedo.ZipTe.domain.service;

import com.eedo.ZipTe.domain.entity.Address;
import com.eedo.ZipTe.domain.entity.Member;
import com.eedo.ZipTe.domain.repository.MemberRepository;
import com.eedo.ZipTe.domain.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public String register(MemberDto dto) {
        Member member = DtoToEntity(dto);
        Member saveMember = memberRepository.save(member);
        return saveMember.getEmail();
    }


    public Member DtoToEntity(MemberDto dto) {


        Member member = Member.builder()
                .email(dto.getEmail())
                .pw(dto.getPw())
                .nickName(dto.getNickName())
                .social(dto.isSocial())
                .Address(Address.builder()
                        .juso(dto.getJuso())
                        .sebu(dto.getSebu())
                        .zipCode(dto.getZipCode()).build())
                .build();

        return member;
    }
}
