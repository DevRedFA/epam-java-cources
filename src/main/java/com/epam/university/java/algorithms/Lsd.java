package com.epam.university.java.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class Lsd {
    public static int R = 3;
    public static int SHIFT_FOR_FIRST_LETTER = 63;

    private static int getKey(String s, int k) {
        if (k > s.length()) {
            return 0;
        } else {
            return s.charAt(k - 1) - SHIFT_FOR_FIRST_LETTER;
        }
    }


    /**
     * Sort by Lsd for full length.
     *
     * @param a - massive to be sorted.
     */
    public static void sortLsd(String[] a) {
        Optional<String> max = Arrays.stream(a).max(Comparator.comparingInt(String::length));
        max.ifPresent(s -> sortLsd(a, s.length()));

    }


    /**
     * Sort by Lsd for K characters, counted from the end.
     *
     * @param a - massive to be sorted.
     * @param K - count of characters of massive sorted, start from the end.
     */
    public static void sortLsd(String[] a, int K) {
        int max = 0;
        for (String st : a) {
            if (st.length() > max) {
                max = st.length();
            }
        }
        int[] count = new int[R + 2];
        String[] temp = new String[a.length];
        for (int d = K; d > 0; d--) {
            for (String anA : a) {
                int key = getKey(anA, d);
                count[key + 1]++;
            }
            for (int i = 0; i < count.length - 1; i++) {
                count[i + 1] += count[i];
            }
            for (String anA : a) {
                temp[count[getKey(anA, d)]++] = anA;
            }
            System.arraycopy(temp, 0, a, 0, a.length);
            count = new int[R + 2];
        }
    }
}
