package org.example.storage;

import org.example.model.Resume;

public interface Storage {
  void save(Resume r);

  Resume get(String uuid);

  void update(Resume r);

  void delete(String uuid);

  int size();

  Resume[] getAll();

  void clear();
}
