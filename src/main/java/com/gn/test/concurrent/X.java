package com.gn.test.concurrent;

public class X {

    public Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        X x = new X();
        new Thread(()->{
            synchronized (x.lock) {
                try {
                    x.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("exit");
            }
        }).start();

        Thread.sleep(2000L);
        synchronized (x.lock) {
            x.lock.notify();
        }
        System.out.println("haha");
    }
}
