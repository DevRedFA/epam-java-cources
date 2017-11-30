package com.epam.university.java.spring.quoters;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTerminatorQuoter {
    @Test
    public void test_context_xml() throws InterruptedException {
        final ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/quoters/context.xml");
        while (true) {
            Thread.sleep(100);
            Quoter bean = classPathXmlApplicationContext.getBean(Quoter.class);
            bean.sayQuote();
        }
    }
}
