package com.javanio;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FilesExample {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("io/readme.txt");
//        String s = Files.readString(path);
//        System.out.println(s);
        System.out.println("-----------------------------------");
      /*  byte[] bytes = Files.readAllBytes(path);
        System.out.println(Arrays.toString(bytes));*/
//        List<String> readAllLines = Files.readAllLines(path);
//        readAllLines.forEach(System.out::println);
//        Path path1 = Path.of("nio/readme.txt");
//        Files.writeString(path1, "Hello World" + new Date() + "\n", StandardOpenOption.APPEND);
        /*Path path1 = Path.of("nio/readme2.txt");
        if (!Files.exists(path1))
            Files.createFile(path1);*/
        /*Path path1 = Path.of("nio", "f1", "f2", "f3");
        if (!Files.exists(path1))
            Files.createDirectories(path1);
        Path resolve = path1.resolve("readme3.txt");
        if (!Files.exists(resolve))
            Files.createFile(resolve);
        Files.write(resolve, "Elshod ".getBytes());
        Files.copy(resolve, Path.of("nio/f1/f2/goddjob.txt"));*/
        Path walkPath = Path.of("/home/dilshod/Documents/PROJECTS/JAVA/modul3");
        for (Path w : Files.walk(walkPath).toList()) {
            if (Files.isRegularFile(w)) {
                System.out.println(w);
            }
        }

    }
}
