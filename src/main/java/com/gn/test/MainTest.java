package com.gn.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class MainTest {

        public static void main(String[] args) throws IOException {
            InputStreamReader input1=new InputStreamReader(System.in);
            BufferedReader in=new BufferedReader(input1);
            String str1=in.readLine();
            String str2=in.readLine();
            System.out.println(getLongestSubString(str1, str2));
        }

//        public static String getLongestSubString(String str1, String str2) {
//            String longestSubStr = "";
//            for (int i = 0; i < str1.length(); i++) {
//                StringBuilder sb = new StringBuilder();
//                for (int j = i; j < str1.length(); j++) {
//                    sb.append(str1.charAt(j));
//                    String sub = sb.toString();
//                    if (str2.contains(sub) && sub.length() > longestSubStr.length()) {
//                        longestSubStr = sub;
//                    }
//                }
//            }
//
//            if (longestSubStr.equals("")) {
//                return "-1";
//            }
//
//            return longestSubStr;
//        }

    public static String getLongestSubString(String str1, String str2) {
        int[][] dp = new int[str1.length()][str2.length()];
        int maxLength = 0, i0 = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                dp[i][0] = 1;
                maxLength = 1;
                i0 = 0;
            }
        }

//        for (int i = 0; i < str2.length(); i++) {
//            if (str2.charAt(i) == str1.charAt(0)) {
//                dp[0][i] = 1;
//            }
//        }

        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        i0 = i;
                    }
                }
            }
        }

        if (maxLength == 0)
            return "-1";

        return str1.substring(i0 + 1 - maxLength, i0+1);
    }
}
