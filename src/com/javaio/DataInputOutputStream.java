package com.javaio;

import java.io.*;

public class DataInputOutputStream {
    public static void main(String[] args) {
        output();
        input();

    }

    private static void input() {
        try (FileInputStream fileInputStream = new FileInputStream("io/dataOutputStream.txt");
             DataInputStream dataInputStream = new DataInputStream(fileInputStream)) {
            double readDouble = dataInputStream.readDouble();
            System.out.println("readDouble = " + readDouble);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void output() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("io/dataOutputStream.txt");
             DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)) {
            dataOutputStream.writeDouble(12d);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
