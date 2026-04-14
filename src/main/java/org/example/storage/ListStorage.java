package org.example.storage;

import java.util.ArrayList;
import java.util.List;
import org.example.model.Resume;

public class ListStorage extends AbstractStorage<Integer> {

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
  protected void doSave(Integer searchKey, Resume r) {
    storage.add(r);
  }

  @Override
  protected Resume doGet(Integer searchKey) {
    return storage.get(searchKey);
  }

  @Override
  protected void doUpdate(Integer searchKey, Resume r) {
    storage.set(searchKey, r);
  }

  @Override
  protected void doDelete(Integer searchKey) {
    int index = searchKey;
    storage.remove(index);
  }

  @Override
  protected Integer getSearchKey(String uuid) {
    for (int i = 0; i < storage.size(); i++) {
      if (uuid.equals(storage.get(i).getUuid())) {
        return i;
      }
    }
    return -1;
  }

  @Override
  protected boolean exists(Integer searchKey) {
    return (Integer) searchKey >= 0;
  }

  @Override
  protected List<Resume> getAllAsList() {
    return new ArrayList<>(storage);
  }
}
