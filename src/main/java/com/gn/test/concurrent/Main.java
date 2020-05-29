package com.gn.test.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Task()).start();
        new Thread(new Task()).start();
        new Thread(new Task()).start();
        new Thread(()->{
            Task.number = 1;
            System.out.println("stop");
        }).start();
        new Thread(new Task()).start();
        new Thread(new Task()).start();
//        new Thread(new ZeroTask()).start();



        Thread.sleep(1000);
//        Thread.sleep(1000);
//        System.out.println(ZeroTask.number);
    }

    static class Task implements Runnable {
        public static int number = 0;

        private ExecutorService service = Executors.newCachedThreadPool();

        @Override
        public void run() {
            while (number == 0) {
                System.out.println("xx");
            }

            Future future = service.submit(new Runnable() {
                @Override
                public void run() {

                }
            });

            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
