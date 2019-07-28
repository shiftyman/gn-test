package com.gn.test.polymorphic.test2;

public class Pen {

    public static enum Color {
        BLACK("black", 52),
        RED("red", 1),;

        private String color;
        private int index;

        Color(String color, int index) {
            this.color = color;
            this.index = index;
        }

        public String getColor() {
            return color;
        }

        public int getIndex() {
            return index;
        }
    }

    private Color color = Color.BLACK;

    public Color getColor() {
        return color;
    }
}
