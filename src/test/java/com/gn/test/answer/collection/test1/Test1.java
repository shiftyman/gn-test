package com.gn.test.answer.collection.test1;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Test1 {

    public static void main(String[] args) {
        List<Map<String, Map<String, Object>>> list = new LinkedList<>();

        Map<String, Map<String, Object>> tongji = new HashMap<>();
        Map<String, Object> tongjiC1 = new HashMap<>();
        tongjiC1.put("name", "classA");
        tongjiC1.put("studentCount", 20);
        tongjiC1.put("majorClass", false);

        Map<String, Object> tongjiC2 = new HashMap<>();
        tongjiC2.put("name", "classB");
        tongjiC2.put("studentCount", 21);
        tongjiC2.put("majorClass", true);

        tongji.put("classA", tongjiC1);
        tongji.put("classB", tongjiC2);

        Map<String, Map<String, Object>> jianqiao = new HashMap<>();
        Map<String, Object> jianqiaoC1 = new HashMap<>();
        jianqiaoC1.put("name", "jian1");
        jianqiaoC1.put("studentCount", 34);
        jianqiaoC1.put("majorClass", true);

        Map<String, Object> jianqiaoC2 = new HashMap<>();
        jianqiaoC2.put("name", "jian2");
        jianqiaoC2.put("studentCount", 36);
        jianqiaoC2.put("majorClass", false);

        jianqiao.put("jian1", jianqiaoC1);
        jianqiao.put("jian2", jianqiaoC2);

        list.add(jianqiao);
        list.add(tongji);

        System.out.println(JSON.toJSONString(list));
        checkYourAnswer(JSON.toJSONString(list));
    }

    private static void checkYourAnswer(String answer) {
        String expert = "[{\"jian2\":{\"studentCount\":36,\"majorClass\":false,\"name\":\"jian2\"},\"jian1\":{\"studentCount\":34,\"majorClass\":true,\"name\":\"jian1\"}},{\"classB\":{\"studentCount\":21,\"majorClass\":true,\"name\":\"classB\"},\"classA\":{\"studentCount\":20,\"majorClass\":false,\"name\":\"classA\"}}]";
        if (answer.equals(expert)) {
            System.out.println("Congratulations!");
        } else {
            System.out.println("Error!!!!!!!!!!!");
        }
    }
}
