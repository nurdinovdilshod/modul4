package com.java_synchronization.race_condition;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public Bank(int n, double initialBalance) {
        this.accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    public void transfer(int from, int to, double amount) throws InterruptedException {
        try {
            lock.lock();
            while (accounts[from] < amount)
                condition.await();
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total balance is %10.2f%n", getTotalBalance());
            condition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        synchronized (this) {
            while (accounts[from] < amount)
                condition.wait();
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total balance is %10.2f%n", getTotalBalance());
            this.notifyAll();
        }
    }

    private Object getTotalBalance() {


        return null;
    }
}
