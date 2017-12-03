package com.epam.university.java.spring.reaper.quoters;

public class T1000 extends TerminatorQuoter implements Quoter{
    @Override
    public void sayQuote() {
        System.out.println("I am liquid");
    }
}
