package com.urise.webapp;

import java.io.File;
import java.io.IOException;

public class MainDirectoryFile {
    public static void main(String[] args) throws IOException {
        printTreeFiles(new File("D:\\Java\\basejava\\src"));
    }

    public static void printTreeFiles(File directory) {
        if (directory.exists()) {
            getContent(directory, 0);
        } else System.out.println("directory is not found...");
    }

    public static void getContent(File directory, int indents) {
        for (int i = 0; i < indents; i++) System.out.print("\t");

        if (directory.isFile()) System.out.println(directory.getName());
        else {
            System.out.println(directory.getName());
            File[] subDirectory = directory.listFiles();
            for (File subWay : subDirectory)
                getContent(subWay, indents + 1);
        }
    }
}