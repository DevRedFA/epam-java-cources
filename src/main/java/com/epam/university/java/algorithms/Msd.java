package com.epam.university.java.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.BiFunction;

public class Msd<T> {
    public static int SHIFT_FOR_FIRST_LETTER = 0;
    public static int R = 256;
    private static String[] temp;

    // Don't use it, because of losses on boxing/unboxing.
    class getKeyDefaultFunc implements BiFunction<String, Integer, Integer> {
        @Override
        public Integer apply(String s, Integer i) {
            return getKeyDefault(s, i);
        }
    }

    private static int getKeyDefault(String s, int d) {
        if (d < s.length()) return s.charAt(d) - SHIFT_FOR_FIRST_LETTER;
        else return 0;
    }


    public static void sortMsd(String[] a) {
        Optional<String> max = Arrays.stream(a).max(Comparator.comparingInt(String::length));
        max.ifPresent(s -> sortMsd(a, s.length()));
    }

    public static void sortMsd(String[] a, int K) {
        int N = a.length;
        temp = new String[N];
        sort(a, 0, N - 1, 0, K - 1);
    }

    private static void sort(String[] a, int lo, int hi, int d, int K) {
        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++)
            count[getKeyDefault(a[i], d) + 1]++;
        for (int r = 0; r < R + 1; r++)
            count[r + 1] += count[r];
        for (int i = lo; i <= hi; i++)
            temp[count[getKeyDefault(a[i], d)]++] = a[i];
        System.arraycopy(temp, 0, a, lo, hi + 1 - lo);
        if (d < K) {
            for (int r = 0; r < R; r++)
                if (count[r + 1] - count[r] > 0) {
                    sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1, K);
                }
        }
    }

    public static void sortMsd(String[] a, BiFunction<String, Integer, Integer> getKey) {
        Optional<String> max = Arrays.stream(a).max(Comparator.comparingInt(String::length));
        max.ifPresent(s -> sortMsd(a, s.length(), getKey));
    }

    public static void sortMsd(String[] a, int K, BiFunction<String, Integer, Integer> getKey) {
        int N = a.length;
        temp = new String[N];
        sort(a, 0, N - 1, 0, K - 1, getKey);
    }

    private static void sort(String[] a, int lo, int hi, int d, int K, BiFunction<String, Integer, Integer> getKey) {
        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++) {
            count[getKey.apply(a[i], d) + 1]++;
        }
        for (int r = 0; r < R + 1; r++)
            count[r + 1] += count[r];
        for (int i = lo; i <= hi; i++) {
            temp[count[getKey.apply(a[i], d)]++] = a[i];
        }
        System.arraycopy(temp, 0, a, lo, hi + 1 - lo);
        if (d < K) {
            for (int r = 0; r < R; r++)
                if (count[r + 1] - count[r] > 0) {
                    sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1, K, getKey);
                }
        }
    }


    public static <T> void sortMsd(T[] a, int K, BiFunction<T, Integer, Integer> getKey) {
        int N = a.length;
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[N];
        sort(a, temp, 0, N - 1, 0, K - 1, getKey);
    }

    private static <T> void sort(T[] a, T[] temp, int lo, int hi, int d, int K, BiFunction<T, Integer, Integer> getKey) {
        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++) {
            count[getKey.apply(a[i], d) + 1]++;
        }
        for (int r = 0; r < R + 1; r++)
            count[r + 1] += count[r];
        for (int i = lo; i <= hi; i++) {
            temp[count[getKey.apply(a[i], d)]++] = a[i];
        }
        System.arraycopy(temp, 0, a, lo, hi + 1 - lo);
        if (d < K) {
            for (int r = 0; r < R; r++)
                if (count[r + 1] - count[r] > 0) {
                    sort(a, temp, lo + count[r], lo + count[r + 1] - 1, d + 1, K, getKey);
                }
        }
    }
}

