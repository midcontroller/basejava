package org.example.storage;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import org.example.exception.ResumeAlreadyExistsException;
import org.example.exception.ResumeNotFoundException;
import org.example.model.Resume;

public abstract class AbstractStorage<K> implements Storage {

  @Override
  public final void save(Resume r) {
    Objects.requireNonNull(r, "Resume must not be null");
    K searchKey = getSearchKey(r.getUuid());
    if (exists(searchKey)) {
      throw new ResumeAlreadyExistsException(r.getUuid());
    }
    doSave(searchKey, r);
  }

  @Override
  public final Resume get(String uuid) {
    Objects.requireNonNull(uuid, "Uuid must not be null");
    K searchKey = getSearchKey(uuid);
    if (!exists(searchKey)) {
      throw new ResumeNotFoundException(uuid);
    }
    return doGet(searchKey);
  }

  @Override
  public final void update(Resume r) {
    Objects.requireNonNull(r, "Resume must not be null");
    K searchKey = getSearchKey(r.getUuid());
    if (!exists(searchKey)) {
      throw new ResumeNotFoundException(r.getUuid());
    }
    doUpdate(searchKey, r);
  }

  @Override
  public final void delete(String uuid) {
    Objects.requireNonNull(uuid, "Uuid must not be null");
    K searchKey = getSearchKey(uuid);
    if (!exists(searchKey)) {
      throw new ResumeNotFoundException(uuid);
    }
    doDelete(searchKey);
  }

  @Override
  public List<Resume> getAllSorted() {
    return getAllAsList().stream()
        .sorted(Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid))
        .toList();
  }

  protected abstract boolean exists(K searchKey);

  protected abstract void doSave(K searchKey, Resume r);

  protected abstract Resume doGet(K searchKey);

  protected abstract void doUpdate(K searchKey, Resume r);

  protected abstract void doDelete(K searchKey);

  protected abstract K getSearchKey(String uuid);

  protected abstract List<Resume> getAllAsList();
}
