package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member newMember = new Member(1L, "memberA", Grade.VIP);

        memberService.join(newMember);
        Member foundMember = memberService.findMember(1L);

        System.out.println("newMember = " + newMember);
        System.out.println("foundMember = " + foundMember);
    }

}
