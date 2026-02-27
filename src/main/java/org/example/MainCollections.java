package org.example;

import java.util.ArrayList;
import java.util.Collection;
import org.example.model.Resume;

public class MainCollections {
  public static void main(String[] args) {
    Collection<Resume> collection = new ArrayList<>();

    collection.add(new Resume());
  }
}
