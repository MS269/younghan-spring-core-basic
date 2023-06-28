package hello.core.member;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    private final MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given
        Member givenMember = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(givenMember);
        Member foundMember = memberService.findMember(1L);

        // then
        assertEquals(foundMember, givenMember);
    }

}