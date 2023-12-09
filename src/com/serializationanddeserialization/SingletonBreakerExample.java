package com.serializationanddeserialization;

import java.io.*;

public class SingletonBreakerExample {
    public static void main(String[] args) {
        write();
        read();


    }

    private static void read() {
        try {
            File file = new File("serdeser/file.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream obInputStream = new ObjectInputStream(fileInputStream);
            Singleton singleton = (Singleton) obInputStream.readObject();
            System.out.println(System.identityHashCode(singleton));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void write() {
        try {
            Singleton singleton = Singleton.getSingleton();
            System.out.println(System.identityHashCode(singleton));

            File file = new File("serdeser/file.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(singleton);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
