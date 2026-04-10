package org.example.storage;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import org.example.exception.ResumeAlreadyExistsException;
import org.example.exception.ResumeNotFoundException;
import org.example.model.Resume;

public abstract class AbstractStorage implements Storage {

  @Override
  public final void save(Resume r) {
    Objects.requireNonNull(r, "Resume must not be null");
    Object searchKey = getNotExistedSearchKey(r.getUuid());
    doSave(searchKey, r);
  }

  @Override
  public final Resume get(String uuid) {
    Objects.requireNonNull(uuid, "Uuid must not be null");
    Object searchKey = getExistedSearchKey(uuid);
    return doGet(searchKey);
  }

  @Override
  public final void update(Resume r) {
    Objects.requireNonNull(r, "Resume must not be null");
    Object searchKey = getExistedSearchKey(r.getUuid());
    doUpdate(searchKey, r);
  }

  @Override
  public final void delete(String uuid) {
    Objects.requireNonNull(uuid, "Uuid must not be null");
    Object searchKey = getExistedSearchKey(uuid);
    doDelete(searchKey);
  }

  @Override
  public List<Resume> getAllSorted() {
    return getAllAsList().stream()
        .sorted(Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid))
        .toList();
  }

  protected Object getNotExistedSearchKey(String uuid) {
    Object searchKey = getSearchKey(uuid);
    if (isExist(uuid)) {
      throw new ResumeAlreadyExistsException(uuid);
    }
    return searchKey;
  }

  protected Object getExistedSearchKey(String uuid) {
    Object searchKey = getSearchKey(uuid);
    if (!isExist(uuid)) {
      throw new ResumeNotFoundException(uuid);
    }
    return searchKey;
  }

  protected abstract void doSave(Object searchKey, Resume r);

  protected abstract Resume doGet(Object searchKey);

  protected abstract void doUpdate(Object searchKey, Resume r);

  protected abstract void doDelete(Object searchKey);

  protected abstract Object getSearchKey(String uuid);

  protected abstract boolean isExist(String uuid);

  protected abstract List<Resume> getAllAsList();
}
