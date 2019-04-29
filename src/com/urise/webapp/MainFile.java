package com.urise.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) {
        String filePath = ".\\.gitignore";
        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }
        File dir = new File("./src/com/urise/webapp");
        System.out.println(file.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        printDirectoryDeeply(dir, 0);
    }

    public static void printDirectoryDeeply(File directory, int space) {
        for (int i = 0; i < space; i++) System.out.print('\t');
        if (directory.isFile()) {
            System.out.println(directory.getName());
        } else {
            System.out.println(directory.getName());
            File[] files = directory.listFiles();
            for (File file : files) {
                printDirectoryDeeply(file, space + 1);
            }
        }
    }
}


