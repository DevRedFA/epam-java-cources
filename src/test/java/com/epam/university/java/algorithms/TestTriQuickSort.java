package com.epam.university.java.algorithms;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static com.epam.university.java.algorithms.TriQuickSort.sortTriQuick;

public class TestTriQuickSort {

    @Test
    public void sort_by_4_letters() throws InterruptedException {
        String[] a = {"BBBBBB", "AAABCC","AAABAA","AAABBB","AAABBB",  "BBBAAA", "AAAAAA", "AAACCC", "CCCBBB", "CCCAAA"};
        String[] result = getSortedCopy(a);
        TriQuickSort.R = 3;
        sortTriQuick(a, 3);
        Assert.assertArrayEquals(a, result);
    }


    private String[] getSortedCopy(String[] a) {
        String[] result = Arrays.copyOf(a, a.length);
        Arrays.sort(result);
        return result;
    }
}
