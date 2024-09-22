package com.eedo.ZipTe.domain;

import com.eedo.ZipTe.domain.entity.Address;
import com.eedo.ZipTe.domain.entity.Member;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@RequiredArgsConstructor
public class InitDB {
    private final InitService initService;
    @PostConstruct
    public void init() {
        initService.dbInit1();
    }
    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

        public void dbInit1() {
            Member member = Member.builder()
                    .email("doup2001@naver.com")
                    .pw("1111")
                    .nickName("eedo")
                    .social(false)
                    .Address(Address.builder()
                            .juso("경기도 성남시 장미로 55")
                            .sebu("126-602")
                            .zipCode(13441).build())
                    .build();

            em.persist(member);
        }
    }
}