package com.gn.test;

public class Main {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"fl", "flo", "f"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        int i = 0;
        while (true) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || i >= strs[0].length()) {
                    return strs[j].substring(0, i);
                }

                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[j].substring(0, i);
                }
            }
            i++;
        }
    }
}
