package org.example.storage;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.example.exception.StorageOverflowException;
import org.example.model.Resume;
import org.junit.jupiter.api.Test;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {
  protected static final String OVERFLOW = "overflow";

  public AbstractArrayStorageTest(Storage storage) {
    super(storage);
  }

  @Test
  void save_whenStorageFull_throwsStorageOverflowException() {
    storage.clear();
    int limit = AbstractArrayStorage.STORAGE_LIMIT;

    for (int i = 0; i < limit; i++) {
      try {
        storage.save(new Resume("uuid" + i));
      } catch (StorageOverflowException e) {
        fail("Overflow happened too early at i: " + i);
      }
    }

    assertThrows(StorageOverflowException.class, () -> storage.save(new Resume(OVERFLOW)));
  }
}
