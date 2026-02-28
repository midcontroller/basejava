package org.example.storage;

import java.util.ArrayList;
import java.util.List;
import org.example.model.Resume;

public class ListStorage extends AbstractStorage {

  private final List<Resume> storage = new ArrayList<>();

  @Override
  protected void doSave(int index, Resume r) {
    storage.add(r);
  }

  @Override
  protected Resume doGet(int index) {
    return storage.get(index);
  }

  @Override
  protected void doUpdate(int index, Resume r) {
    storage.set(index, r);
  }

  @Override
  protected void doDelete(int index) {
    storage.remove(index);
  }

  @Override
  protected int doSize() {
    return storage.size();
  }

  @Override
  protected Resume[] doGetAll() {
    return storage.toArray(new Resume[0]);
  }

  @Override
  protected void doClear() {
    storage.clear();
  }

  @Override
  protected int findIndex(String uuid) {
    for (int i = 0; i < storage.size(); i++) {
      if (uuid.equals(storage.get(i).getUuid())) {
        return i;
      }
    }
    return -1;
  }
}
