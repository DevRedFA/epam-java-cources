package com.epam.university.java.spring.reaper.screensaver;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "com.epam.university.java.spring.reaper.screensaver")
public class Config {
    @Bean
    @Scope(value = "periodical")
    public Color color() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Bean
    public ColorFrame colorFrame() {
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return color();
            }
        };
    }
}
