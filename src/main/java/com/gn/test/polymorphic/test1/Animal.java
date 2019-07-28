package com.gn.test.polymorphic.test1;

public abstract class Animal {

    void eat() {
        System.out.println("I don't know how to eat!");
    }

    void sleep() {
        System.out.println("I sleep now!");
    }

    void think() {
        System.out.println("I'm an animal first.");
    }
}
