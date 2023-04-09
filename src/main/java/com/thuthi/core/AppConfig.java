package com.thuthi.core;

import com.thuthi.core.discount.FixDiscountPolicy;
import com.thuthi.core.discount.RateDiscountPolicy;
import com.thuthi.core.member.MemberService;
import com.thuthi.core.member.MemberServiceImpl;
import com.thuthi.core.member.MemoryMemberRepository;
import com.thuthi.core.order.OrderService;
import com.thuthi.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
