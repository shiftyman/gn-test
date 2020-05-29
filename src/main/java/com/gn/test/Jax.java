package com.gn.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Jax {

    public static void main(String[] args) {
        List<Line> lines = readFile("/home/test/1");
        Line[] array = lines.toArray(new Line[0]);
        quickSort(array, 0, array.length);
        for (Line i : array) {
            System.out.println(i);
        }
    }

    public static class Line implements Comparable<Line> {
        private int id;
        private String name;
        private String course;
        private int score;

        public Line(int id, String name, String course, int score) {
            this.id = id;
            this.name = name;
            this.course = course;
            this.score = score;
        }

        @Override
        public String toString() {
            return id + "," + name + "," + course + "," + score;
        }

        @Override
        public int compareTo(Line o) {
            return this.score < o.score || (this.score == o.score && this.id < o.id) ? 0 : 1;
        }
    }

    public static List<Line> readFile(String name) {
        List<Line> list = new LinkedList<>();
        try {
            FileReader fr = new FileReader(name);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            str = bf.readLine(); //skip one
            while ((str = bf.readLine()) != null) {
                String[] pieces = str.split(",");
                list.add(new Line(Integer.parseInt(pieces[0]), pieces[1], pieces[2],
                        Integer.parseInt(pieces[3])));
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

//    public static void sort(List<Line> lines){
//        Line[] array = lines.toArray(new Line[0]);
//        quickSort(array, 0, array.length);
//        for (Line i : array) {
//            System.out.println(i);
//        }
//    }

    public static void quickSort(Line[] array, int l, int r) {
        if (l >= r) {
            return;
        }

        Line privot = array[l];
        int left = l, right = r;

        while (left < right) {
            while (left < right &&
                    (array[right].score >= privot.score ||
                            (array[right].score == privot.score && array[right].id >= privot.id))) {
                right--;
            }

            if (left < right) {
                array[left] = array[right];
                left++;
            }

            while (left < right && array[left].score <= privot.score ||
                    (array[left].score == privot.score && array[left].id <= privot.id)) {
                left++;
            }

            if (left < right) {
                array[right] = array[left];
                right--;
            }
        }
        array[left] = privot;

        quickSort(array, l, (l+r) / 2);
        quickSort(array, (l+r) / 2 + 1, r);
    }
}
