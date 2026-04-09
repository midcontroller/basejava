package org.example.storage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.example.model.Resume;

public class MapStorage extends AbstractStorage {

  private final Map<String, Resume> storage = new LinkedHashMap<>();

  @Override
  public int size() {
    return storage.size();
  }

  @Override
  public void clear() {
    storage.clear();
  }

  @Override
  protected List<Resume> getAllAsList() {
    return new ArrayList<>(storage.values());
  }

  @Override
  protected int searchKey(String uuid) {
    return storage.containsKey(uuid) ? 0 : -1;
  }

  @Override
  protected void doSave(int key, Resume r) {
    storage.put(r.getUuid(), r);
  }

  @Override
  protected Resume doGet(int key, String uuid) {
    return storage.get(uuid);
  }

  @Override
  protected void doUpdate(int key, Resume r) {
    storage.put(r.getUuid(), r);
  }

  @Override
  protected void doDelete(int key, String uuid) {
    storage.remove(uuid);
  }
}
