package com.eedo.ZipTe.domain.service;

import com.eedo.ZipTe.domain.dto.MemberDTO;
import com.eedo.ZipTe.domain.entity.Address;
import com.eedo.ZipTe.domain.entity.Member;
import com.eedo.ZipTe.domain.repository.MemberRepository;
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
        MemberDTO dto = MemberDTO.builder()
                .email("doup2001@naver.com")
                .pw("1111")
                .nickName("eedo")
                .social(false)
                .city("경기도 성남시 장미로 55")
                .detail("126-602")
                .zipcode(13441)
                .build();

        //when
        Member member = Member.builder()
                .email(dto.getEmail())
                .pw(dto.getPw())
                .nickName(dto.getNickName())
                .social(dto.isSocial())
                .Address(Address.builder()
                        .juso(dto.getCity())
                        .sebu(dto.getDetail())
                        .zipCode(dto.getZipcode()).build())
                .build();

        //then
        memberService.register(dto);

//        memberRepository.save(member);

    }


}