package org.example.storage;

import java.util.List;
import org.example.model.Resume;

public interface Storage {
  void save(Resume r);

  Resume get(String uuid);

  void update(Resume r);

  void delete(String uuid);

  int size();

  List<Resume> getAllSorted();

  void clear();
}
