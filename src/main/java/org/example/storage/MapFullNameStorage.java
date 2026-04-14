package org.example.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.model.Resume;

public class MapFullNameStorage extends AbstractStorage<String> {

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
  protected boolean exists(String searchKey) {
    return searchKey != null;
  }

  @Override
  protected void doSave(String searchKey, Resume r) {
    storage.put(r.getUuid(), r);
  }

  @Override
  protected Resume doGet(String searchKey) {
    return storage.get(searchKey);
  }

  @Override
  protected void doUpdate(String searchKey, Resume r) {
    storage.put(r.getUuid(), r);
  }

  @Override
  protected void doDelete(String searchKey) {
    storage.remove(searchKey);
  }

  @Override
  protected String getSearchKey(String uuid) {
    return storage.containsKey(uuid) ? uuid : null;
  }

  @Override
  protected List<Resume> getAllAsList() {
    return new ArrayList<>(storage.values());
  }
}
