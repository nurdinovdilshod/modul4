package com.javaio;

import java.io.File;

public class FileExample {
    public static void main(String[] args) {
        File file = new File("io", "readme.txt");
        System.out.println(file.canExecute());
        System.out.println(file.isFile());
        System.out.println(file.getAbsolutePath());
        File file1=new File("io","file1");
        System.out.println(file1.mkdir());
//        file1.delete();
    }
}
