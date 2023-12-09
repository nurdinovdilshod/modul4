package com.uz.tasks;

public class Threading extends Thread {
       /* Runnable runnable=()->{

        };
        var th=new Thread("Elshod");
        System.out.println(th);*/

    public Threading(Runnable target, String name) {
        super(target, name);
    }

    public Threading(String name) {
        super(name);
    }
}

class Task {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Thread thread = new Thread("daemon thread");
            thread.setDaemon(true);
            for (int i = 0; i < 5; i++) {
                System.out.println(i + " -> " + Thread.currentThread().getName());
            }
        };

        for (int i = 0; i < 10; i++) {
            Threading threading = new Threading(runnable, "thread-" + i);
            threading.start();
            System.out.println(threading);
        }
    }
}
