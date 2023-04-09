package com.thuthi.core;

import com.thuthi.core.member.Grade;
import com.thuthi.core.member.Member;
import com.thuthi.core.member.MemberService;
import com.thuthi.core.member.MemberServiceImpl;
import com.thuthi.core.order.Order;
import com.thuthi.core.order.OrderService;
import com.thuthi.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}
