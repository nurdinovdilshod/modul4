package com.asyncronous_programming;

import java.util.concurrent.RecursiveTask;

public class Tasks extends RecursiveTask<Integer> {
    public static final int limit = 10;
    private double[] arr;
    private int start;
    private int end;

    public Tasks(double[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }


    @Override
    public Integer compute() {
        int differ = end - start;
        if (differ < limit) {
            double res = 0;
            for (int i = start; i < end; i++) {
//                System.out.println(arr[i]);
                res += arr[i];
            }
            return (int) res;
        } else {
            int middle = start + differ / 2;
            Tasks first = new Tasks(arr, start, middle);
            Tasks second = new Tasks(arr, middle+1, end);

            invokeAll(first, second);
            return first.join() + second.join();

        }
    }
}
