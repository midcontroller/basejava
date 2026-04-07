package org.example.storage;

import java.util.Comparator;
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
  public List<Resume> getAllSorted() {
    return storage.values().stream()
        .sorted(Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid))
        .toList();
  }

  @Override
  public void clear() {
    storage.clear();
  }

  @Override
  protected int searchKey(String uuid) {
    return storage.containsKey(uuid) ? 0 : -1;
  }

  @Override
  protected void doSave(int key, Resume r) {
    // Ignore the key
    storage.put(r.getUuid(), r);
  }

  @Override
  protected Resume doGet(int key, String uuid) {
    // Ignore the key
    return storage.get(uuid);
  }

  @Override
  protected void doUpdate(int key, Resume r) {
    // Ignore the key
    storage.put(r.getUuid(), r);
  }

  @Override
  protected void doDelete(int key, String uuid) {
    // Ignore the key
    storage.remove(uuid);
  }
}
