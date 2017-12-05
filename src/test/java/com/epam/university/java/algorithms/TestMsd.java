package com.epam.university.java.algorithms;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static com.epam.university.java.algorithms.Lsd.sortLsd;
import static com.epam.university.java.algorithms.Msd.sortMsd;

public class TestMsd {

    @Test
    public void sort_by_4_letters() throws InterruptedException {
        String[] a = {"AA", "CCBA", "BBAA", "AB", "AAA", "ACB"};
        String[] result = getSortedCopy(a);
        Msd.SHIFT_FOR_FIRST_LETTER = 64;
        Msd.R = 3;
        sortMsd(a);
        Assert.assertArrayEquals(a, result);
    }

    @Test
    public void sort_by_5_letters() throws InterruptedException {
        String[] a = {"AAA", "CCBAA", "BBAAA", "ABA", "AAAA", "ACBA"};
        String[] result = getSortedCopy(a);
        Msd.SHIFT_FOR_FIRST_LETTER = 64;
        Msd.R = 3;
        sortMsd(a, 5);
        Assert.assertArrayEquals(a, result);
    }

    @Test
    public void sort_by_5_letters_4_alph() throws InterruptedException {
        String[] a = {"AAA", "CCBAA", "BBAAA", "ABA", "AAAA", "AAAD", "DCBA"};
        String[] result = getSortedCopy(a);
        Msd.SHIFT_FOR_FIRST_LETTER = 64;
        Msd.R = 4;
        sortMsd(a, 5);
        Assert.assertArrayEquals(a, result);
    }

    @Test
    public void sort_by_2_letters_4_alph() throws InterruptedException {
        String[] a = {"AA", "AD", "AB", "AC", "DB", "CA", "CB", "DA"};
        String[] result = getSortedCopy(a);
        Msd.SHIFT_FOR_FIRST_LETTER = 64;
        Msd.R = 4;
        sortMsd(a, 2);
        Assert.assertArrayEquals(a, result);
    }

    @Test
    public void sort_by_3_letters_4_alph() throws InterruptedException {
        String[] a = {"AA", "AAA", "AD", "AB", "AC", "DB", "CA", "CB", "DA"};
        String[] result = getSortedCopy(a);
        Msd.SHIFT_FOR_FIRST_LETTER = 64;
        Msd.R = 4;
        sortMsd(a, 3);
        Assert.assertArrayEquals(a, result);
    }


    @Test
    public void sort_by_3_letters_with_4_letters_words() throws InterruptedException {
        String[] a = {"AABB", "AAAB", "ADBB", "ADAA", "ACAA", "DBBB", "CBBB", "CAAD", "CAAA", "DABB", "DAA"};
        String[] result = {"AAAB", "AABB", "ACAA", "ADAA", "ADBB", "CAAD", "CAAA", "CBBB", "DAA", "DABB", "DBBB"};
        Msd.SHIFT_FOR_FIRST_LETTER = 64;
        Msd.R = 4;
        sortMsd(a, 3);
        Assert.assertArrayEquals(a, result);
    }

    @Test
    public void sort_by_2_letters_with_4_letters_words() throws InterruptedException {
        String[] a = {"AA", "AAA", "AD", "AB", "AC", "DB", "CA", "CB", "DA"};
        String[] result = getSortedCopy(a);
        Msd.SHIFT_FOR_FIRST_LETTER = 64;
        Msd.R = 4;
        sortMsd(a, 2, (s, d) -> {
            if (d < s.length()) return s.charAt(d) - Msd.SHIFT_FOR_FIRST_LETTER;
            else return 0;
        });
        Assert.assertArrayEquals(a, result);
    }

    @Test
    public void sort_by_2_letters_with_bifunc() throws InterruptedException {
        String[] a = {"ABCC", "ACAA", "AACC", "AABB"};
        String[] result = {"AACC", "AABB", "ABCC", "ACAA"};
        Msd.SHIFT_FOR_FIRST_LETTER = 64;
        Msd.R = 4;
        sortMsd(a, 2);
        Assert.assertArrayEquals(a, result);
    }


    private String[] getSortedCopy(String[] a) {
        String[] result = Arrays.copyOf(a, a.length);
        Arrays.sort(result);
        return result;
    }
}
