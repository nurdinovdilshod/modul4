package com.uz.task2;

public class Counter {
    private  int a;

    public  int counter1() {
     synchronized (this){
            a++;
        }
        return a;
    }
}
