package com.thuthi.hellospring.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.thuthi.hellospring.domain.Member;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    void tearDown() {
        repository.clearStore();
    }

    @Test
    public void save() throws Exception {
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        repository.save(member);

        // then
        Member result = repository.findById(member.getId()).get();
        assertEquals(member, result);
    }

    @Test
    public void findByName() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("spring1");

        Member member2 = new Member();
        member2.setName("spring2");

        // when
        repository.save(member1);
        repository.save(member2);

        // then
        Member result1 = repository.findByName("spring1").get();
        Member result2 = repository.findByName("spring2").get();
        assertEquals(member1, result1);
    }

    @Test
    public void findAll() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("spring1");

        Member member2 = new Member();
        member2.setName("spring2");

        // when
        repository.save(member1);
        repository.save(member2);

        // then
        List<Member> result = repository.findAll();
        assertEquals(2, result.size());
    }
}