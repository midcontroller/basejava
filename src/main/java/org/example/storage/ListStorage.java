package org.example.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.example.exception.ResumeAlreadyExistsException;
import org.example.exception.ResumeNotFoundException;
import org.example.model.Resume;

public class ListStorage implements Storage {

  private final List<Resume> resumes = new ArrayList<>();

  @Override
  public void save(Resume r) {
    Objects.requireNonNull(r, "Resume must not be null");

    String uuid = Objects.requireNonNull(r.getUuid(), "Uuid must not be null");

    int index = findIndex(uuid);
    if (index >= 0) {
      throw new ResumeAlreadyExistsException(uuid);
    }

    resumes.add(r);
  }

  @Override
  public Resume get(String uuid) {
    Objects.requireNonNull(uuid, "Uuid must not be null");

    int index = findIndex(uuid);

    if (index < 0) {
      throw new ResumeNotFoundException(uuid);
    }

    return resumes.get(index);
  }

  @Override
  public void update(Resume r) {
    Objects.requireNonNull(r, "Resume must not be null");

    String uuid = Objects.requireNonNull(r.getUuid(), "Uuid must not be null");

    int index = findIndex(uuid);
    if (index < 0) {
      throw new ResumeNotFoundException(uuid);
    }

    resumes.set(index, r);
  }

  @Override
  public void delete(String uuid) {
    Objects.requireNonNull(uuid, "Uuid must not be null");

    int index = findIndex(uuid);

    if (index < 0) {
      throw new ResumeNotFoundException(uuid);
    }

    resumes.remove(index);
  }

  @Override
  public int size() {
    return resumes.size();
  }

  @Override
  public Resume[] getAll() {
    return resumes.toArray(new Resume[0]);
  }

  @Override
  public void clear() {
    resumes.clear();
  }

  private int findIndex(String uuid) {
    Objects.requireNonNull(uuid, "uuid must not be null");

    for (int i = 0; i < resumes.size(); i++) {
      Resume r = resumes.get(i);
      if (uuid.equals(r.getUuid())) {
        return i;
      }
    }
    return -1;
  }
}
