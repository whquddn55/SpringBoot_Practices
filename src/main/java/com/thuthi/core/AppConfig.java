package com.thuthi.core;

import com.thuthi.core.discount.DiscountPolicy;
import com.thuthi.core.discount.FixDiscountPolicy;
import com.thuthi.core.discount.RateDiscountPolicy;
import com.thuthi.core.member.MemberRepository;
import com.thuthi.core.member.MemberService;
import com.thuthi.core.member.MemberServiceImpl;
import com.thuthi.core.member.MemoryMemberRepository;
import com.thuthi.core.order.OrderService;
import com.thuthi.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
