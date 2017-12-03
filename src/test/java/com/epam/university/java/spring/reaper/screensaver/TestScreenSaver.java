package com.epam.university.java.spring.reaper.screensaver;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestScreenSaver {

    @Test
    public void test_color_bean() throws InterruptedException {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true) {
            ColorFrame bean = context.getBean(ColorFrame.class);
            bean.showOnRandomPlace();
            Thread.sleep(100);
        }
    }
}
