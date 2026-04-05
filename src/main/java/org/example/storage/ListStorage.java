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
  protected Resume doGet(int index, String uuid) {
    return storage.get(index);
  }

  @Override
  protected void doUpdate(int index, Resume r) {
    storage.set(index, r);
  }

  @Override
  protected void doDelete(int index, String uuid) {
    storage.remove(index);
  }

  @Override
  public int size() {
    return storage.size();
  }

  @Override
  public void clear() {
    storage.clear();
  }

  @Override
  protected int searchKey(String uuid) {
    for (int i = 0; i < storage.size(); i++) {
      if (uuid.equals(storage.get(i).getUuid())) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public List<Resume> getAllSorted() {
    List<Resume> resumes = new ArrayList<>(storage);
    resumes.sort(null);
    return resumes;
  }
}
