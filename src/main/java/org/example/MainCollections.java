package org.example;

import org.example.model.Resume;

import java.util.ArrayList;
import java.util.Collection;

public class MainCollections {
    public static void main(String[] args) {
        Collection<Resume> collection = new ArrayList<>();

        collection.add(new Resume());
    }
}
