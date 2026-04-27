package org.example.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainFile {
    public static void main(String[] args) {
        try {
            Files.walk(Path.of("src")).forEach(path -> System.out.println(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}