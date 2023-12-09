package com.uz.tasks;

public class Task6 {
    public static void main(String[] args) {
        Runnable daemonRunnable = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                System.out.println(i + " -> " + Thread.currentThread().getName());
            }
        };
        Runnable runnable = () -> {
            MyThread daemonThread = new MyThread(daemonRunnable, "Daemon Sher ");
            daemonThread.setPriority(10);
//            daemonThread.setDaemon(true);
            daemonThread.start();
            for (int i = 0; i < 1000; i++) {
                System.out.println(i + " -> " + Thread.currentThread().getName());
            }
        };
        MyThread myThread = new MyThread(runnable, "Anvar");
        myThread.start();
    }

}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
    }
}
