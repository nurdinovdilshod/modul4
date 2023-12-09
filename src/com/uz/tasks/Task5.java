package com.uz.tasks;

public class Task5 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
    }
}
class Elshod{
    public static void main(String[] args) {
        Task5 task5=new Task5();
        System.out.println("b s");
        task5.run();
        System.out.println("a s");
    }
}
