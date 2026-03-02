package org.example.storage;

import java.util.Arrays;
import org.example.exception.StorageOverflowException;
import org.example.model.Resume;

public abstract class AbstractArrayStorage extends AbstractStorage {
  protected static final int STORAGE_LIMIT = 100_000;
  protected final Resume[] storage = new Resume[STORAGE_LIMIT];
  protected int size = 0;

  @Override
  protected void doSave(int index, Resume r) {
    if (size >= STORAGE_LIMIT) {
      throw new StorageOverflowException();
    }

    insert(index, r);
    size++;
  }

  @Override
  protected Resume doGet(int index, String uuid) {
    return storage[index];
  }

  @Override
  protected void doUpdate(int index, Resume r) {
    storage[index] = r;
  }

  @Override
  protected void doDelete(int index, String uuid) {
    remove(index);
    storage[--size] = null;
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
  public Resume[] getAll() {
    return Arrays.copyOf(storage, size);
  }

  @Override
  public void clear() {
    Arrays.fill(storage, 0, size, null);
    size = 0;
  }

  protected abstract void remove(int index);

  protected abstract void insert(int index, Resume r);
}
