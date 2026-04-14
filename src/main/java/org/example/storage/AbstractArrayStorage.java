package org.example.storage;

import java.util.Arrays;
import java.util.List;
import org.example.exception.StorageOverflowException;
import org.example.model.Resume;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
  protected static final int STORAGE_LIMIT = 100_000;
  protected final Resume[] storage = new Resume[STORAGE_LIMIT];
  protected int size = 0;

  @Override
  protected void doSave(Integer searchKey, Resume r) {
    if (size >= STORAGE_LIMIT) {
      throw new StorageOverflowException();
    }

    insert(searchKey, r);
    size++;
  }

  @Override
  protected Resume doGet(Integer searchKey) {
    return storage[searchKey];
  }

  @Override
  protected void doUpdate(Integer searchKey, Resume r) {
    storage[searchKey] = r;
  }

  @Override
  protected void doDelete(Integer searchKey) {
    remove(searchKey);
    storage[size] = null;
    size--;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public String toString() {
    return "AbstractArrayStorage{}";
  }

  @Override
  public void clear() {
    Arrays.fill(storage, 0, size, null);
    size = 0;
  }

  @Override
  protected boolean exists(Integer searchKey) {
    return searchKey >= 0;
  }

  @Override
  protected List<Resume> getAllAsList() {
    return Arrays.stream(storage, 0, size).toList();
  }

  protected abstract void remove(int index);

  protected abstract void insert(int index, Resume r);
}
