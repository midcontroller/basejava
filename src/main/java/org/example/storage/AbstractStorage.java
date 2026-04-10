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
    if (isExist(r.getUuid())) {
      throw new ResumeAlreadyExistsException(r.getUuid());
    }
    Object searchKey = getSearchKey(r.getUuid());
    doSave(searchKey, r);
  }

  @Override
  public final Resume get(String uuid) {
    Objects.requireNonNull(uuid, "Uuid must not be null");
    if (!isExist(uuid)) {
      throw new ResumeNotFoundException(uuid);
    }
    Object searchKey = getSearchKey(uuid);
    return doGet(searchKey);
  }

  @Override
  public final void update(Resume r) {
    Objects.requireNonNull(r, "Resume must not be null");
    if (!isExist(r.getUuid())) {
      throw new ResumeNotFoundException(r.getUuid());
    }
    Object searchKey = getSearchKey(r.getUuid());
    doUpdate(searchKey, r);
  }

  @Override
  public final void delete(String uuid) {
    Objects.requireNonNull(uuid, "Uuid must not be null");
    if (!isExist(uuid)) {
      throw new ResumeNotFoundException(uuid);
    }
    Object searchKey = getSearchKey(uuid);
    doDelete(searchKey);
  }

  @Override
  public List<Resume> getAllSorted() {
    return getAllAsList().stream()
        .sorted(Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid))
        .toList();
  }

  protected abstract boolean isExist(String uuid);

  protected abstract void doSave(Object searchKey, Resume r);

  protected abstract Resume doGet(Object searchKey);

  protected abstract void doUpdate(Object searchKey, Resume r);

  protected abstract void doDelete(Object searchKey);

  protected abstract Object getSearchKey(String uuid);

  protected abstract List<Resume> getAllAsList();
}
