package com.field_visibility;

public class FieldVisibilityProblem {

    public static void main(String[] args) throws InterruptedException {
        var r1 = new MyRunnable1();
        var th1 = new Thread(r1,"Thread 1");
        var th2 = new Thread(r1,"Thread 2");
        th1.start();
        th2.start();
        Thread.sleep(2000);
        r1.stop();
    }

}

class MyRunnable1 implements Runnable {
    private volatile boolean active;

    @Override
    public void run() {
        active = true;
        while (active) {
        }
        System.out.println(Thread.currentThread() + "::::::::::::::: Finished ::::::::::::::");
    }

    public void stop() {
        active= !active;
    }
}
