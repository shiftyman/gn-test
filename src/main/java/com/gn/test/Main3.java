package com.gn.test;

public class Main3 {

    public static void main(String[] args) {
//        System.out.println(myAtoi("-12dfsdf"));
//        System.out.println(myAtoi("+12dfsdf"));
//        System.out.println(myAtoi("   +12dfsdf"));
//        System.out.println(myAtoi("   -12dfsdf"));
//        System.out.println(myAtoi("   -1234   "));
//        System.out.println(myAtoi("   -"));
//        System.out.println(myAtoi(""));
        System.out.println(myAtoi("9223372036854775808"));
    }

    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int index = 0;
        while (index < chars.length && chars[index] == ' ') {
            index ++;
        }

        if (index == chars.length) {
            return 0;
        }

        boolean ne = false;
        if (chars[index] == '-') {
            ne = true;
            index++;
        } else if (chars[index] == '+') {
            index++;
        }

        long number = 0;
        while (index < chars.length) {
            int n = chars[index] - '0';
            if (n <= 9 && n >= 0) {
                number = number * 10 + n;
                index++;
                if (number > Integer.MAX_VALUE) {
                    return ne ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }

        return ne ? (int) -number : (int) number;
    }
}
