package com.gn.test.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.IntConsumer;

class ZeroEvenOdd2 {
    private int n;
    private AtomicBoolean zeroLatch = new AtomicBoolean(true), oddLatch = new AtomicBoolean(), evenLatch = new AtomicBoolean();

    public ZeroEvenOdd2(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (true) {
                if (!zeroLatch.compareAndSet(true, false)) {
                    Thread.yield();
                } else {
                    break;
                }
            }

            printNumber.accept(0);
            zeroLatch.set(false);
            if (i % 2 == 0) {
                oddLatch.set(true);
            } else {
                evenLatch.set(true);
            }

        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n / 2; i++) {
            while (true) {
                if (!evenLatch.compareAndSet(true, false)) {
                    Thread.yield();
                } else {
                    break;
                }
            }

            printNumber.accept((i << 1) + 2);
            evenLatch.set(false);
            zeroLatch.set(true);
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int r = n % 2 > 0 ? n / 2 + 1 : n / 2;
        for (int i = 0; i < r; i++) {
            while (true) {
                if (!oddLatch.compareAndSet(true, false)) {
                    Thread.yield();
                } else {
                    break;
                }
            }

            printNumber.accept((i << 1) + 1);
            oddLatch.set(false);
            zeroLatch.set(true);
        }
    }

    public static class ZeroTask implements Runnable {

        private ZeroEvenOdd2 zeroEvenOdd;

        public ZeroTask(ZeroEvenOdd2 zeroEvenOdd) {
            this.zeroEvenOdd = zeroEvenOdd;
        }

        @Override
        public void run() {
            try {
                zeroEvenOdd.zero(e -> System.out.print(e));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class OddTask implements Runnable {

        private ZeroEvenOdd2 zeroEvenOdd;

        public OddTask(ZeroEvenOdd2 zeroEvenOdd) {
            this.zeroEvenOdd = zeroEvenOdd;
        }

        @Override
        public void run() {
            try {
                zeroEvenOdd.odd(e -> System.out.print(e));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class EvenTask implements Runnable {

        private ZeroEvenOdd2 zeroEvenOdd;

        public EvenTask(ZeroEvenOdd2 zeroEvenOdd) {
            this.zeroEvenOdd = zeroEvenOdd;
        }

        @Override
        public void run() {
            try {
                zeroEvenOdd.even(e -> System.out.print(e));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) {
        ZeroEvenOdd2 zeroEvenOdd = new ZeroEvenOdd2(4);
        new Thread(new EvenTask(zeroEvenOdd)).start();
        new Thread(new ZeroTask(zeroEvenOdd)).start();
        new Thread(new OddTask(zeroEvenOdd)).start();
    }
}
