package com.thuthi.core;

import com.thuthi.core.discount.DiscountPolicy;
import com.thuthi.core.discount.RateDiscountPolicy;
import com.thuthi.core.member.MemberRepository;
import com.thuthi.core.member.MemberService;
import com.thuthi.core.member.MemberServiceImpl;
import com.thuthi.core.member.MemoryMemberRepository;
import com.thuthi.core.order.OrderService;
import com.thuthi.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
