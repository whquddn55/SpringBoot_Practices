package com.thuthi.hellospring.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.thuthi.hellospring.domain.Member;
import com.thuthi.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
    MemberService memberService = new MemberService(memoryMemberRepository);

    @AfterEach
    void tearDown() {
        memoryMemberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        Member result = memberService.findOne(saveId).get();
        assertThat(result.getName()).isEqualTo(member.getName());
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);

        // then
        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));
        assertThat(exception.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMember() {
    }

    @Test
    void findOne() {
    }
}