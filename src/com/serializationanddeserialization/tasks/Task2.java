package com.serializationanddeserialization.tasks;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task2 {
    public static void main(String[] args) {
        Book book = new Book("Elshod", 222, "Films");
        write(book);
        Book read = read();
        System.out.println(read);
    }

    private static void write(Book book) {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream("nio/task2.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ) {
            objectOutputStream.writeObject(book);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Book read() {
        try (
                FileInputStream fileInputStream = new FileInputStream("nio/task2.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            return (Book) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
