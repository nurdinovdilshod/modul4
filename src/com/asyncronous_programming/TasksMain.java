package com.asyncronous_programming;

import java.util.concurrent.ForkJoinPool;

public class TasksMain {
    public static void main(String[] args) {
        int size = 1000;
        double[] arr = new double[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Math.random();
        }
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Tasks tasks = new Tasks(arr, 0, size);
        Integer invoke = forkJoinPool.invoke(tasks);
        System.out.println("All = " + invoke);
    }
}
