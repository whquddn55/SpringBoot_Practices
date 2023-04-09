package com.thuthi.core.order;

import com.thuthi.core.AppConfig;
import com.thuthi.core.member.Grade;
import com.thuthi.core.member.Member;
import com.thuthi.core.member.MemberService;
import com.thuthi.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    private final AppConfig appConfig = new AppConfig();
    private final MemberService memberService = appConfig.memberService();
    private final OrderService orderService = appConfig.orderService();

    @Test
    public void createOrder() throws Exception {
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Order itemA = orderService.createOrder(memberId, "itemA", 10000);

        // then
        Assertions.assertThat(itemA.calculatePrice()).isEqualTo(9000);
    }
}
