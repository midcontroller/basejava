package org.example.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.model.Resume;

public class MapResumeStorage extends AbstractStorage<Resume> {

  private final Map<String, Resume> map = new HashMap<>();

  @Override
  public int size() {
    return map.size();
  }

  @Override
  public void clear() {
    map.clear();
  }

  @Override
  protected boolean exists(Resume searchKey) {
    return searchKey != null;
  }

  @Override
  protected void doSave(Resume searchKey, Resume r) {
    map.put(r.getUuid(), r);
  }

  @Override
  protected Resume doGet(Resume searchKey) {
    return searchKey;
  }

  @Override
  protected void doUpdate(Resume searchKey, Resume r) {
    map.put(r.getUuid(), r);
  }

  @Override
  protected void doDelete(Resume searchKey) {
    map.remove(searchKey.getUuid());
  }

  @Override
  protected Resume getSearchKey(String uuid) {
    return map.get(uuid);
  }

  @Override
  protected List<Resume> getAllAsList() {
    return new ArrayList<>(map.values());
  }
}
