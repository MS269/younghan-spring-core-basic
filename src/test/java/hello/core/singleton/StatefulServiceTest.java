package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        statefulService1.order("userA", 10000); // ThreadA: 사용자A 10000원 주문
        statefulService1.order("userB", 20000); // ThreadB: 사용자B 20000원 주문

        int price = statefulService1.getPrice(); // ThreadA: 사용자A 주문 금액 조회
        System.out.println("price = " + price);

        Assertions.assertNotEquals(10000, statefulService1.getPrice());
        Assertions.assertEquals(20000, statefulService2.getPrice());
    }

    @Test
    void statelessServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatelessService statelessService1 = ac.getBean(StatelessService.class);
        StatelessService statelessService2 = ac.getBean(StatelessService.class);

        int userAPrice = statelessService1.order("userA", 10000); // ThreadA: 사용자A 10000원 주문
        int userBPrice = statelessService2.order("userB", 20000); // ThreadB: 사용자B 20000원 주문

        System.out.println("userAPrice = " + userAPrice);
        System.out.println("userBPrice = " + userBPrice);

        Assertions.assertEquals(10000, userAPrice);
        Assertions.assertEquals(20000, userBPrice);
    }

    @Configuration
    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }

        @Bean
        StatelessService statelessService() {
            return new StatelessService();
        }

    }

}