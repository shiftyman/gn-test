package com.gn.test.collection.test1;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 集合运用
 */
public class demo1 {

    /**
     * 以下程序会输出如下格式的json数据：
     *
     * {
     *     "class2":[
     *         {
     *             "name":"zp",
     *             "age":"29"
     *         },
     *         {
     *             "name":"zx",
     *             "age":"25"
     *         },
     *         {
     *             "name":"Tony",
     *             "age":"21"
     *         }
     *     ],
     *     "class1":[
     *         {
     *             "name":"Xiaoming",
     *             "age":"18"
     *         },
     *         {
     *             "name":"Xiaopeng",
     *             "age":"26"
     *         }
     *     ]
     * }
     *
     * @param args
     */
    public static void main(String[] args) {
        Map<String, List<Map<String, String>>> toJsonMap = new HashMap<>();

        List<Map<String, String>> class1 = new LinkedList<>();
        Map<String, String> c1no1 = new HashMap<>();
        c1no1.put("name", "Xiaoming");
        c1no1.put("age", "18");
        class1.add(c1no1);

        Map<String, String> c1no2 = new HashMap<>();
        c1no2.put("name", "Xiaopeng");
        c1no2.put("age", "26");
        class1.add(c1no2);

        List<Map<String, String>> class2 = new LinkedList<>();
        Map<String, String> c2no1 = new HashMap<>();
        c2no1.put("name", "zp");
        c2no1.put("age", "29");
        class2.add(c2no1);

        Map<String, String> c2no2 = new HashMap<>();
        c2no2.put("name", "zx");
        c2no2.put("age", "25");
        class2.add(c2no2);

        Map<String, String> c2no3 = new HashMap<>();
        c2no3.put("name", "Tony");
        c2no3.put("age", "21");
        class2.add(c2no3);

        toJsonMap.put("class1", class1);
        toJsonMap.put("class2", class2);

        // 通过fastjson外部库将数据结构转换成json字符串
        System.out.println(JSON.toJSONString(toJsonMap));
    }


}
