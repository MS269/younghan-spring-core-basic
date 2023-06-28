package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private final MemberService memberService = new MemberServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member newMember = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(newMember);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        assertEquals(order.getDiscountPrice(), 1000);
    }

}