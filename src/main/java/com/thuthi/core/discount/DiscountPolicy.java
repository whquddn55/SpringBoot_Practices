package com.thuthi.core.discount;

import com.thuthi.core.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
