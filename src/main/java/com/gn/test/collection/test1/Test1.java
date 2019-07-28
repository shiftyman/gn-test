package com.gn.test.collection.test1;

public class Test1 {

    /**
     * 这里有两所学校的数据，请通过Map和List将数据凑出来, 不允许定义新的class：
     * 注意，其中有bool值，也有数值型！！！！！！！
     * [
     *     {
     *         "jian2":{
     *             "studentCount":36,
     *             "majorClass":false,
     *             "name":"jian2"
     *         },
     *         "jian1":{
     *             "studentCount":34,
     *             "majorClass":true,
     *             "name":"jian1"
     *         }
     *     },
     *     {
     *         "classB":{
     *             "studentCount":21,
     *             "majorClass":true,
     *             "name":"classB"
     *         },
     *         "classA":{
     *             "studentCount":20,
     *             "majorClass":false,
     *             "name":"classA"
     *         }
     *     }
     * ]
     *
     * @param args
     */
    public static void main(String[] args) {
        String answer = null;

        //todo



        // 检验结果，无需改动
        checkYourAnswer(answer);
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
