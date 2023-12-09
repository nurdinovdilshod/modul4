package com.threadpool;

import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
    public static void main(String[] args) {
        saveUserToDatabase();
        generateTemplate();
        sendMail();
        System.out.println("...........................");
    }

    public static void saveUserToDatabase() {
        Runnable runnable = () -> {
            try {
                System.out.println("Save to database...........");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("User saved to database...........");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        new Thread(runnable).start();
    }

    public static void generateTemplate() {
        Runnable runnable = () -> {
            try {
                System.out.println("Generating template...........");
                TimeUnit.MILLISECONDS.sleep(400);
                System.out.println("Template generated...........");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        new Thread(runnable).start();
    }

    public static void sendMail() {
        Runnable runnable = () -> {
            try {
                System.out.println("Connecting to smtp server...........");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Mail sent...........");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        new Thread(runnable).start();
    }
}
