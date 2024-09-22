package com.eedo.ZipTe.domain.service;

import com.eedo.ZipTe.domain.dto.MemberDto;
import com.eedo.ZipTe.domain.entity.Address;
import com.eedo.ZipTe.domain.entity.Member;
import com.eedo.ZipTe.domain.repository.MemberRepository;
import com.eedo.ZipTe.domain.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@Log4j2
@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @Test
    public void register() throws Exception{
        //given
        MemberDto dto = MemberDto.builder()
                .email("doup2001@naver.com")
                .pw("1111")
                .nickName("eedo")
                .social(false)
                .juso("경기도 성남시 장미로 55")
                .sebu("126-602")
                .zipCode(13441)
                .build();

        //when
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

        //then
        memberService.register(dto);

//        memberRepository.save(member);

    }


}