package org.example.storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.example.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

  @Override
  protected void remove(int index) {
    storage[index] = storage[size - 1];
  }

  @Override
  protected void insert(int index, Resume r) {
    storage[size] = r;
  }

  @Override
  protected int searchKey(String uuid) {
    for (int i = 0; i < size; i++) {
      if (uuid.equals(storage[i].getUuid())) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public List<Resume> getAllSorted() {
    Resume[] actual = Arrays.copyOf(storage, size);
    List<Resume> resumes = new ArrayList<>(Arrays.asList(actual));
    resumes.sort(null);
    return resumes;
  }
}
