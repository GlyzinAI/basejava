package com.urise.webapp;

import java.io.File;

public class MainDirTree {
    public static void main(String[] args) {
        list("D:/Java/basejava/src");
    }

    public static void list(String filePath) {
        File file = new File(filePath);
        String[] listFiles = file.list();
        for (int i = 0; i < listFiles.length; i++) {
            File newFile = new File(filePath + File.separator + listFiles[i]);
            if (newFile.isFile()) {
                System.out.println(filePath + File.separator + listFiles[i]);
            } else {
                list(filePath + File.separator + listFiles[i]);
            }
        }
    }
}
