package org.example.model;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class MainFile {
    public static void main(String[] args) {
        Path srcPath = Path.of("src").normalize();

        if (!Files.isDirectory(srcPath)) {
            System.out.println("Directory does not exist: " + srcPath);
            return;
        }

        try (Stream<Path> paths = Files.walk(srcPath)) {
            paths.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
