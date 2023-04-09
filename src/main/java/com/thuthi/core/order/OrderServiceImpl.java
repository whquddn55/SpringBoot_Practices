package com.thuthi.core.order;

import com.thuthi.core.discount.DiscountPolicy;
import com.thuthi.core.discount.FixDiscountPolicy;
import com.thuthi.core.discount.RateDiscountPolicy;
import com.thuthi.core.member.Member;
import com.thuthi.core.member.MemberRepository;
import com.thuthi.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
