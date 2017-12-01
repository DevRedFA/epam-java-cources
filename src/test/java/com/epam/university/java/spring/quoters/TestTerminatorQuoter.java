package com.epam.university.java.spring.quoters;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTerminatorQuoter {
    @Test
    public void test_context_xml() throws InterruptedException {
        final ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/quoters/context.xml");
        Quoter bean = classPathXmlApplicationContext.getBean(Quoter.class);
        bean.sayQuote();
    }

    @Test
    public void test_context_properties() throws InterruptedException {
        PropertyFileApplicationContext context = new PropertyFileApplicationContext("/spring/quoters/context.properties");
        context.getBean(Quoter.class).sayQuote();
    }
}
