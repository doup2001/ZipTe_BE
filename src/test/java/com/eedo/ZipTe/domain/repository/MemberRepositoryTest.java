package com.eedo.ZipTe.domain.repository;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.test.context.SpringBootTest;

//import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class MemberRepositoryTest {


//    @Autowired
//    private MemberRepository memberRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Test
//    public void testRegisterMember() throws Exception{
//
//        //given
//        for (int i = 0; i < 10; i++) {
//            Member member = Member.builder()
//                    .email("doup200"+i+"@naver.com")
//                    .pw(passwordEncoder.encode("1111"))
//                    .nickName("USER "+i)
//                    .social(false)
//                    .build();
//
//            member.addRole(MemberRole.USER_GREEN);
//
//            if (i >= 2)
//                member.addRole(MemberRole.USER_VIP);
//            if (i >= 5)
//                member.addRole(MemberRole.MANAGER);
//            if (i >= 8)
//                member.addRole(MemberRole.ADMIN);
//
//            memberRepository.save(member);
//        }
//
//
//    }
//
//    @Test
//    public void testRead() throws Exception {
//        //given
//
//        String email = "doup2009@naver.com";
//
//
//        //when
//
//        Optional<Member> result = memberRepository.getWithRoles(email);
//        Member member = result.orElseThrow();
//
//        //then
//        Assertions.assertEquals(member.getNickName(), "USER 9");
//        //left join이 걸려있는것을 볼 수 있다.
//    }

}
