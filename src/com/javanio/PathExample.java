package com.javanio;

import java.nio.file.Path;

public class PathExample {
        public static void main(String[] args) {

        Path path = Path.of("nio", "readme.txt ");
        System.out.println(path.isAbsolute());
//        path = path.resolve("testFolder");
        System.out.println(path);
        path = path.normalize().toAbsolutePath();
        System.out.println(path);
        System.out.println("path.getFileName() = " + path.getFileName());
//        System.out.println(path.getParent());
        Path parentPath = path.getParent();
        System.out.println(parentPath);
        System.out.println(parentPath.getParent());
        System.out.println(parentPath.getParent());
        System.out.println(parentPath.getParent().getParent());
        System.out.println(parentPath.getParent().getParent().getParent());
            System.out.println(path.getRoot());
        }
}
