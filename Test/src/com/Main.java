package com;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("");
        String currentPath = path.toAbsolutePath().toString();

        File folder = new File(currentPath + "\\Temperature\\src\\com\\models");
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File listOfFile : listOfFiles) {
                System.out.println(listOfFile.getName());
            }
        }
    }
}
