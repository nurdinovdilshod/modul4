package com.serializationanddeserialization;

import java.io.*;

public class SerializationExample2 {
    public static void main(String[] args) {
        write();
        read();


    }

    private static void read() {
        try {
            File file = new File("serdeser/file.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream obInputStream = new ObjectInputStream(fileInputStream);
            Employee2 o = (Employee2) obInputStream.readObject();
            System.out.println(o);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void write() {
        try {
            Employee2 employee = new Employee2("Nuriddinov Dilshod", "+998930504561", "23");
            File file = new File("serdeser/file.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employee);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
