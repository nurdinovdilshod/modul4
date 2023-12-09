package com.javaio;

import java.io.*;

public class BufferedReaderWriterExample {
    public static void main(String[] args) {

        File file = new File("io/readme2.txt");
//        reader(file);

        try (FileWriter fileWriter = new FileWriter(file,true)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Hello Dilshod How Are You My Friend \n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void reader(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while (bufferedReader.ready()) {
                String s = bufferedReader.readLine();
                if (s == null) break;
                System.out.println(s);
            }
//            System.out.println(bufferedReader.readLine());
//            System.out.println(bufferedReader.readLine());
//            System.out.println(bufferedReader.readLine());
//            System.out.println(bufferedReader.readLine());
            /*List<String> strings = bufferedReader.lines().toList();
            for (int i = 0; i < strings.size(); i++) {
                System.out.printf("Line number '%d'-%s %n ", i+1,strings.get(i));
            }*/
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
