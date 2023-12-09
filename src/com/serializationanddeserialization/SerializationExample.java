package com.serializationanddeserialization;

import java.io.*;

public class SerializationExample {
    public static void main(String[] args) {
        write();
        read();


    }

    private static void read() {
        try {
            Employee employee = new Employee("Nuriddinov Dilshod", "+998930504561", "23");
            File file = new File("serdeser/file.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream obInputStream = new ObjectInputStream(fileInputStream);
            Employee o = (Employee) obInputStream.readObject();
            System.out.println(employee);
            System.out.println(o);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void write() {
        try {
            Employee employee = new Employee("Nuriddinov Dilshod", "+998930504561", "23");
            File file = new File("serdeser/file.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employee);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
