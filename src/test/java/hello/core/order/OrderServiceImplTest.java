package hello.core.order;

import hello.core.discount.FixedDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "memberA", Grade.VIP));

        OrderService orderService = new OrderServiceImpl(memberRepository, new FixedDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);

        assertEquals(1000, order.getDiscountPrice());
    }

}