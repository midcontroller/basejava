package org.example.storage;

import java.util.ArrayList;
import java.util.List;
import org.example.model.Resume;

public class ListStorage extends AbstractStorage {

  private final List<Resume> storage = new ArrayList<>();

  @Override
  public int size() {
    return storage.size();
  }

  @Override
  public void clear() {
    storage.clear();
  }

  @Override
  protected void doSave(Object searchKey, Resume r) {
    storage.add(r);
  }

  @Override
  protected Resume doGet(Object searchKey) {
    return storage.get((Integer) searchKey);
  }

  @Override
  protected void doUpdate(Object searchKey, Resume r) {
    storage.set((Integer) searchKey, r);
  }

  @Override
  protected void doDelete(Object searchKey) {
    int index = (Integer) searchKey;
    storage.remove(index);
  }

  @Override
  protected Object getSearchKey(String uuid) {
    for (int i = 0; i < storage.size(); i++) {
      if (uuid.equals(storage.get(i).getUuid())) {
        return i;
      }
    }
    return -1;
  }

  @Override
  protected boolean exists(Object searchKey) {
    return (Integer) searchKey >= 0;
  }

  @Override
  protected List<Resume> getAllAsList() {
    return new ArrayList<>(storage);
  }
}
