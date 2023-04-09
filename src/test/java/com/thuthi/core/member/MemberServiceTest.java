package com.thuthi.core.member;

import static org.assertj.core.api.Assertions.*;

import com.thuthi.core.AppConfig;
import com.thuthi.core.order.OrderService;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    private final AppConfig appConfig = new AppConfig();
    private final MemberService memberService = appConfig.memberService();
    @Test
    public void join() throws Exception {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        assertThat(member).isEqualTo(findMember);
    }
}
