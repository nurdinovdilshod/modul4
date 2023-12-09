package com.javaio;

import java.io.*;

public class FileReaderFileWriterExample {
    public static void main(String[] args) {
//        reader();


        File file = new File("io/readme2.txt");
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.append("\n");
            fileWriter.append("Nuriddinov Dilshod");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void reader() {
        File file = new File("io/readme.txt");
        try (FileReader fileReader = new FileReader(file)) {
            int i;
            StringBuilder a = new StringBuilder();
            while ((i = fileReader.read()) != -1) {
                a.append((char) i);
            }
            System.out.println(a);
            //            System.out.println("fileReader.read() = " + (char)fileReader.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
