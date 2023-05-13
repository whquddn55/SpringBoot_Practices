package com.thuthi.hellospring;

import com.thuthi.hellospring.aop.TimeTraceAop;
import com.thuthi.hellospring.repository.JdbcMemberRepository;
import com.thuthi.hellospring.repository.JdbcTemplateMemberRepository;
import com.thuthi.hellospring.repository.JpaMemberRepository;
import com.thuthi.hellospring.repository.MemberRepository;
import com.thuthi.hellospring.repository.MemoryMemberRepository;
import com.thuthi.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new JpaMemberRepository(entityManager);
//    }

//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
}
