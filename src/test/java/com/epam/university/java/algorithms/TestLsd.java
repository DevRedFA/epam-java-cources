package com.epam.university.java.algorithms;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static com.epam.university.java.algorithms.Lsd.sortLsd;

public class TestLsd {

    @Test
    public void sort_by_4_letters() throws InterruptedException {
        String[] a = {"AA", "CCBA", "BBAA", "AB", "AAA", "ACB"};
        String[] result = getSortedCopy(a);
        Lsd.SHIFT_FOR_FIRST_LETTER = 64;
        Lsd.R = 3;
        sortLsd(a, 4);
        Assert.assertArrayEquals(a, result);
    }

    @Test
    public void sort_by_5_letters() throws InterruptedException {
        String[] a = {"AAA", "CCBAA", "BBAAA", "ABA", "AAAA", "ACBA"};
        String[] result = getSortedCopy(a);
        Lsd.SHIFT_FOR_FIRST_LETTER = 64;
        Lsd.R = 3;
        sortLsd(a, 5);
        Assert.assertArrayEquals(a, result);
    }

    @Test
    public void sort_by_5_letters_4_alph() throws InterruptedException {
        String[] a = {"AAA", "CCBAA", "BBAAA", "ABA", "AAAA", "AAAD", "DCBA"};
        String[] result = getSortedCopy(a);
        Lsd.SHIFT_FOR_FIRST_LETTER = 64;
        Lsd.R = 4;
        sortLsd(a, 5);
        Assert.assertArrayEquals(a, result);
    }

    @Test
    public void sort_by_5_letters_4_alph_auto_max() throws InterruptedException {
        String[] a = {"AAA", "CCBAA", "BBAAA", "ABA", "AAAA", "AAAD", "DCBA"};
        String[] result = getSortedCopy(a);
        Lsd.SHIFT_FOR_FIRST_LETTER = 64;
        Lsd.R = 4;
        sortLsd(a);
        Assert.assertArrayEquals(a, result);
    }

    @Test
    public void sort_by_2_letters_4_alph() throws InterruptedException {
        String[] a = {"AA", "AD", "AB", "AC", "DB", "CA", "CB", "DA"};
        String[] result = getSortedCopy(a);
        Lsd.SHIFT_FOR_FIRST_LETTER = 64;
        Lsd.R = 4;
        sortLsd(a, 2);
        Assert.assertArrayEquals(a, result);
    }

    @Test
    public void sort_by_3_letters_4_alph() throws InterruptedException {
        String[] a = {"AA", "AAA", "AD", "AB", "AC", "DB", "CA", "CB", "DA"};
        String[] result = getSortedCopy(a);
        Lsd.SHIFT_FOR_FIRST_LETTER = 64;
        Lsd.R = 4;
        sortLsd(a, 3);
        Assert.assertArrayEquals(a, result);
    }

    private String[] getSortedCopy(String[] a) {
        String[] result = Arrays.copyOf(a, a.length);
        Arrays.sort(result);
        return result;
    }
}
