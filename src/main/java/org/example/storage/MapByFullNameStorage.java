package org.example.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.model.Resume;

public class MapByFullNameStorage extends AbstractStorage {

  private final Map<String, Resume> storage = new HashMap<>();

  @Override
  public int size() {
    return storage.size();
  }

  @Override
  public void clear() {
    storage.clear();
  }

  @Override
  protected boolean isExist(Object searchKey) {
    return searchKey != null;
  }

  @Override
  protected void doSave(Object searchKey, Resume r) {
    storage.put(r.getUuid(), r);
  }

  @Override
  protected Resume doGet(Object searchKey) {
    return storage.get((String) searchKey);
  }

  @Override
  protected void doUpdate(Object searchKey, Resume r) {
    storage.put(r.getUuid(), r);
  }

  @Override
  protected void doDelete(Object searchKey) {
    storage.remove((String) searchKey);
  }

  @Override
  protected Object getSearchKey(String uuid) {
    return storage.containsKey(uuid) ? uuid : null;
  }

  @Override
  protected List<Resume> getAllAsList() {
    return new ArrayList<>(storage.values());
  }
}
