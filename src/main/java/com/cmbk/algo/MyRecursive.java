package com.cmbk.algo;

import java.util.*;

public class MyRecursive {
    static long findFactorialIterative(int n) {
        long result = 1;
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                result *= i;
            }

            return result;
        }

        return 0;
    }

    static long findFactorialRecursive(int n) {
        if (n > 0) {
            if (n == 1 || n == 2) return n;
            int next = n - 1;
            return n * findFactorialRecursive(next);
        }

        return 0;
    }

    static Map<Long, Long> map;

    static {
        map = new TreeMap<>();
        map.put(1l, 1l);
        map.put(0l, 0l);
    }

    static long fibonacciRecursive(long n) {
        if (n > 0) {
            if (n < 2) {
                map.put(n, n);
                return n;
            }

            long next1 = fibonacciRecursive(n - 1);
            long next2 = fibonacciRecursive(n - 2);
            map.put(next1 + next2, next1 + next2);
            return next1 + next2;
        }
        return 0;
    }

    static List fibonacciIterative(long n) {
        if (n > 0) {
            List<Integer> result = new ArrayList<>();
            result.add(0);
            result.add(1);
            for (int i = 2; i < n; i++) {
                result.add(result.get(i - 1) + result.get(i - 2));
            }

            return result;
        }
        return null;
    }

    static String reverseString(String input) {
        if (input != null && !input.isEmpty()) {
            String[] split = input.split("");
            Stack<String> stak1 = new Stack<>();
            Stack<String> stak2 = new Stack<>();
            for (int i = 0; i < input.length(); i++) {
                stak1.push(split[i]);
            }

            while (!stak1.isEmpty()) {
                stak2.push(stak1.pop());
            }
            return stak2.toString();
        }
        return null;
    }

    static String reverseStringRecursive(String input) {
        if (input != null && !input.isEmpty()) {
            if (input.length() == 1) {
                return input;
            }
            return reverseStringRecursive(input.substring(1)) + input.charAt(0);
        }
        return input;
    }

    public static void main(String[] args) {
        //System.out.println(findFactorialRecursive(20) == findFactorialIterative(20));
        System.out.println("fibonacciSequence(10) = " + fibonacciIterative(20));
        //System.out.println(reverseString("Mbuyamba"));
        System.out.println(reverseStringRecursive(""));
    }
}
