package org.example.storage;

import java.util.Objects;
import org.example.exception.ResumeAlreadyExistsException;
import org.example.exception.ResumeNotFoundException;
import org.example.model.Resume;

public abstract class AbstractStorage implements Storage {

  @Override
  public final void save(Resume r) {
    Objects.requireNonNull(r, "Resume must not be null");
    String uuid = r.getUuid();

    int key = searchKey(uuid);
    if (key >= 0) {
      throw new ResumeAlreadyExistsException(uuid);
    }

    doSave(key, r);
  }

  @Override
  public final Resume get(String uuid) {
    Objects.requireNonNull(uuid, "Uuid must not be null");

    int key = searchKey(uuid);
    if (key < 0) {
      throw new ResumeNotFoundException(uuid);
    }

    return doGet(key, uuid);
  }

  @Override
  public final void update(Resume r) {
    Objects.requireNonNull(r, "Resume must not be null");
    String uuid = r.getUuid();

    int key = searchKey(uuid);
    if (key < 0) {
      throw new ResumeNotFoundException(uuid);
    }

    doUpdate(key, r);
  }

  @Override
  public final void delete(String uuid) {
    Objects.requireNonNull(uuid, "Uuid must not be null");

    int key = searchKey(uuid);
    if (key < 0) {
      throw new ResumeNotFoundException(uuid);
    }

    doDelete(key, uuid);
  }

  protected abstract int searchKey(String uuid);

  protected abstract void doSave(int key, Resume r);

  protected abstract Resume doGet(int key, String uuid);

  protected abstract void doUpdate(int key, Resume r);

  protected abstract void doDelete(int key, String uuid);
}
