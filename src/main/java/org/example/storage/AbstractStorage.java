package org.example.storage;

import java.util.Objects;
import org.example.exception.ResumeAlreadyExistsException;
import org.example.exception.ResumeNotFoundException;
import org.example.model.Resume;

public abstract class AbstractStorage implements Storage {

  @Override
  public final void save(Resume r) {
    Objects.requireNonNull(r, "Resume must not be null");
    String uuid = Objects.requireNonNull(r.getUuid(), "Uuid must not be null");

    int index = findIndex(uuid);
    if (index >= 0) {
      throw new ResumeAlreadyExistsException(uuid);
    }

    doSave(index, r);
  }

  @Override
  public final Resume get(String uuid) {
    Objects.requireNonNull(uuid, "Uuid must not be null");

    int index = findIndex(uuid);
    if (index < 0) {
      throw new ResumeNotFoundException(uuid);
    }

    return doGet(index);
  }

  @Override
  public final void update(Resume r) {
    Objects.requireNonNull(r, "Resume must not be null");
    String uuid = Objects.requireNonNull(r.getUuid(), "Uuid must not be null");

    int index = findIndex(uuid);
    if (index < 0) {
      throw new ResumeNotFoundException(uuid);
    }

    doUpdate(index, r);
  }

  @Override
  public final void delete(String uuid) {
    Objects.requireNonNull(uuid, "Uuid must not be null");

    int index = findIndex(uuid);
    if (index < 0) {
      throw new ResumeNotFoundException(uuid);
    }

    doDelete(index);
  }

  @Override
  public final int size() {
    return doSize();
  }

  @Override
  public final Resume[] getAll() {
    return doGetAll();
  }

  @Override
  public final void clear() {
    doClear();
  }

  protected abstract int findIndex(String uuid);

  protected abstract void doSave(int index, Resume r);

  protected abstract Resume doGet(int index);

  protected abstract void doUpdate(int index, Resume r);

  protected abstract void doDelete(int index);

  protected abstract int doSize();

  protected abstract Resume[] doGetAll();

  protected abstract void doClear();
}
