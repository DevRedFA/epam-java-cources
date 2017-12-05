package com.epam.university.java.algorithms;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.epam.university.java.algorithms.Msd.sortMsd;

/**
 * Algorithm, adapted for work with grouped data.
 * <p>
 * "AAABCD"
 * "AAADCA"
 * "BBAADA"
 * "BBAADA"
 */
public class TriQuickSort {
    public static Map<String, Integer> map;
    public static int SHIFT_FOR_FIRST_LETTER = 0;
    public static int R = 256;

    static class OutString {
        public String data;
        int hashCode;

        public OutString(String data, int n) {
            this.data = data;
            for (int i = 0; i < n; i++) {
                hashCode += (R ^ i) * data.charAt(i);
            }
        }
    }

    public static void sortTriQuick(String[] a, int n) throws InterruptedException {
        Msd.SHIFT_FOR_FIRST_LETTER = 64;
        Msd.R = 4;
        OutString[] aOut = new OutString[a.length];
        for (int i = 0; i < a.length; i++) {
            aOut[i] = new OutString(a[i], n);
        }

//        Msd.sortMsd(aOut, 1, (outString, integer) -> outString.hashCode);
        Arrays.sort(aOut, Comparator.comparingInt(o -> o.hashCode));
        String[] sortedByGroups = transfer(aOut, String.class, outString -> outString.data);

        Optional<String> max = Arrays.stream(sortedByGroups).max(Comparator.comparingInt(String::length));
        max.ifPresent(s -> sortTriQuick(a, n, s.length()));

        Thread.sleep(10);
    }

    /**
     * @param a massive to be sorted.
     * @param d from which letter need to be sorted.
     * @param K up which letter need to be sorted.
     */
    public static void sortTriQuick(String[] a, int d, int K) {
        sortTriQuick(a, d, 0, a.length, K);
    }

    public static void sortTriQuick(String[] a, int d, int from, int to, int K) {
        int low = from;
        int high = to;
        int index = getKey(a[from], d);
        for (int i = from + 1; i < high; ) {
            if (index < getKey(a[i], d)) {
                swap(a, i,high);
                high--;
            }
            if (index > getKey(a[i], d)) {
                swap(a, i,low);
                low++;
                i++;
            }
            if (index < getKey(a[i], d)) {
                i++;
            }
        }

    }

    private static <T> void swap(T[] a, int firstPos, int secondPos) {
        T first = a[firstPos];
        a[firstPos] = a[secondPos];
        a[secondPos] = first;
    }


    private static int getKey(String s, int d) {
        if (d < s.length()) return s.charAt(d) - SHIFT_FOR_FIRST_LETTER;
        else return 0;

    }

    private static <T, U> T[] transfer(U[] u, Class<T> clazz, Function<U, T> function) {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) Array.newInstance(clazz, u.length);
        for (int i = 0; i < u.length; i++) {
            result[i] = function.apply(u[i]);
        }
        return result;
    }
}
