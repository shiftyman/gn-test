package com.gn.test.polymorphic.test2;

import java.util.HashSet;
import java.util.Set;

public class Test2 {

    public static void main(String[] args) {
        Set<Object> set = new HashSet<>();
        set.add(0);
        set.add("Guinv");
        set.add(new Pen());
        set.add(null);
        set.add(1314.0d);

        // 请从set中取值，然后给这些变量赋值 todo
        int number0 = -1;
        String guinv = null;
        int colorIndex = -1;
        double doubleVal = -1;
        String expert = null;

        for (Object value : set) {
            // todo 请对上述几个变量进行赋值，以满足后续输出正确

        }

        // 检验结果，无需改动
        expert = "" + colorIndex + number0 + guinv + doubleVal;
        checkYourAnswer(expert);
    }


    private static void checkYourAnswer(String answer) {
        String expert = "520Guinv1314.0";
        if (answer.equals(expert)) {
            System.out.println("Congratulations!");
        } else {
            System.out.println("Error!!!!!!!!!!!");
        }
    }
}
