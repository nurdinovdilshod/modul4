package com.javaio;

import java.io.*;

public class FileInputOutputStream {
    public static void main(String[] args) {
//        inputStream();
        try (InputStream inputStream = new FileInputStream("io/readme.txt");
                OutputStream outputStream = new FileOutputStream("io/readme2.txt")) {
            outputStream.write("Hello World ".getBytes());
            inputStream.transferTo(outputStream);
//            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void inputStream() {
        try (InputStream inputStream = new FileInputStream("io/readme.txt")) {
            byte[] bytes = inputStream.readAllBytes();
            String data = new String(bytes);
            System.out.println("data= " + data);
//            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
