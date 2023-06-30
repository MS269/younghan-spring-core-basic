package hello.core.member;

import hello.core.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    private MemberService memberService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

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