package com.example.hongs.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    public void testMember() {
        // given
//        Member member = new Member();
//        member.setUsername("memberA");
//
//        // when
////        Long savedId = memberRepository.save(member);
////        Member findMember = memberRepository.find(savedId);
////
////        // then
////        Assertions.assertEquals(findMember.getId(), member.getId());
////        Assertions.assertEquals(findMember.getUsername(), member.getUsername());
    }
}
