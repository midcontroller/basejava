package org.example;

import java.io.File;

public class MainFile {

    public static void main(String[] args) {
        File directory = new File("src");
        printPaths(directory);
    }

    private static void printPaths(File directory) {
        printPaths(directory, "");
    }

    private static void printPaths(File directory, String indent) {
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory + " is not directory");
        }

        File[] paths = directory.listFiles();
        if (paths == null) {
            return;
        }
        for (File path : paths) {
            System.out.println(indent + path.getName());
            if (path.isDirectory()) {
                printPaths(path, indent + "  ");
            }
        }
    }
}
