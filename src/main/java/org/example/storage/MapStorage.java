package org.example.storage;

import java.util.LinkedHashMap;
import java.util.Map;
import org.example.model.Resume;

public class MapStorage extends AbstractStorage {

  private final Map<String, Resume> storage = new LinkedHashMap<>();
  int size = 0;

  @Override
  public int size() {
    return size;
  }

  @Override
  public Resume[] getAll() {
    return storage.values().toArray(new Resume[0]);
  }

  @Override
  public void clear() {
    storage.clear();
    size = 0;
  }

  @Override
  protected int findIndex(String uuid) {
    return storage.containsKey(uuid) ? 0 : -1;
  }

  @Override
  protected void doSave(int index, Resume r) {
    storage.put(r.getUuid(), r);
    size++;
  }

  @Override
  protected Resume doGet(int index, String uuid) {
    return storage.get(uuid);
  }

  @Override
  protected void doUpdate(int index, Resume r) {
    storage.put(r.getUuid(), r);
  }

  @Override
  protected void doDelete(int index, String uuid) {
    storage.remove(uuid);
    size--;
  }
}
