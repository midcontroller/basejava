package org.example.storage;

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
  protected Object getSearchKey(String uuid) {
    for (int i = 0; i < size; i++) {
      if (uuid.equals(storage[i].getUuid())) {
        return i;
      }
    }
    return -1;
  }
}
