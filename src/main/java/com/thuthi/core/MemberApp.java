package com.thuthi.core;

import com.thuthi.core.member.Grade;
import com.thuthi.core.member.Member;
import com.thuthi.core.member.MemberService;
import com.thuthi.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("memberA = " + memberA);
        System.out.println("findMember = " + findMember);
    }
}
