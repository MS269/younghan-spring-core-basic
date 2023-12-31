package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void givenMemberWhenIsVipThenDiscount10Percent() {
        Member vip = new Member(1L, "memberVIP", Grade.VIP);

        int discountPrice = discountPolicy.discount(vip, 10000);

        assertEquals(discountPrice, 1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void givenMemberWhenIsBasicThenNoDiscount() {
        Member basic = new Member(2L, "memberBASIC", Grade.BASIC);

        int discountPrice = discountPolicy.discount(basic, 10000);

        assertEquals(discountPrice, 0);
    }

}
