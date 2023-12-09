package com.uz.workingwithThreads;

public class Threading {
    public static void main(String[] args) {
//        System.out.println(Thread.currentThread().getName());
//        MyTasks myTasks = new MyTasks();
//        myTasks.start();
//        MyRunnableTask target = new MyRunnableTask();
//        Thread thread = new Thread(target);
//        thread.start();

        /*Runnable runnable = () -> {
            for (int i = 0; i < 15; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName() + " ->" + i);
            }
        };*/
//        Thread thread1 = new Thread(runnable);

        threading();
    }

    private static void threading() {
        new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                    }
                    System.out.println(Thread.currentThread().getName() + " ->" + i);
            }
        }, "MyThread").start();
        System.out.println("Hello world");
    }
}

class MyRunnableTask implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + " ->" + i);
        }
    }
}

class MyTasks extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {

            }
            System.out.println(Thread.currentThread().getName() + " ->" + i);
        }
    }
}