package com.cmbk.data.structure;

public class ListTest {
    public static void main(String[] args) {
        String string = "Je suis avec vous!";
        System.out.println(reverse(string));
    }

    static String reverse(String string) {
        if (string == null) return null;
        String[] split = string.split("");
        String[] backward = new String[split.length];
        int j = 0;
        for (int i = split.length - 1; i >= 0; i--) {
            backward[j++] = split[i];
        }

        StringBuilder value = new StringBuilder();

        for (String s : backward) {
            value.append(s);
        }

        return value.toString();
    }
}
