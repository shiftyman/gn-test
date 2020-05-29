package com.gn.test.concurrent;

import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private final Object zeroCond, oddCond, evenCond;
    private boolean zeroLatch = true, oddLatch, evenLatch;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.zeroCond = new Object();
        this.oddCond = new Object();
        this.evenCond = new Object();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (zeroCond) {
                if (!zeroLatch) {
                    zeroCond.wait();
                }

                printNumber.accept(0);
                if (i % 2 == 0) {
                    synchronized (oddCond) {
                        oddLatch = true;
                        oddCond.notify();
                    }
                } else {
                    synchronized (evenCond) {
                        evenLatch = true;
                        evenCond.notify();
                    }
                }

                zeroLatch = false;
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n / 2; i++) {
            synchronized (evenCond) {
                if (!evenLatch) {
                    evenCond.wait();
                }

                printNumber.accept((i << 1) + 2);
                synchronized (zeroCond) {
                    zeroLatch = true;
                    zeroCond.notify();
                }

                evenLatch = false;
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int r = n % 2 > 0 ? n/2+1 : n/2;
        for (int i = 0; i < r; i++) {
            synchronized (oddCond) {
                if (!oddLatch) {
                    oddCond.wait();
                }

                printNumber.accept((i<<1) + 1);
                synchronized (zeroCond) {
                    zeroLatch = true;
                    zeroCond.notify();
                }

                oddLatch = false;
            }
        }
    }

    public static class ZeroTask implements Runnable {

        private ZeroEvenOdd zeroEvenOdd;

        public ZeroTask(ZeroEvenOdd zeroEvenOdd) {
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

        private ZeroEvenOdd zeroEvenOdd;

        public OddTask(ZeroEvenOdd zeroEvenOdd) {
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

        private ZeroEvenOdd zeroEvenOdd;

        public EvenTask(ZeroEvenOdd zeroEvenOdd) {
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
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(4);
        new Thread(new EvenTask(zeroEvenOdd)).start();
        new Thread(new ZeroTask(zeroEvenOdd)).start();
        new Thread(new OddTask(zeroEvenOdd)).start();
    }
}
