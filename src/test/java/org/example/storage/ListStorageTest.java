package org.example.storage;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.exception.ResumeAlreadyExistsException;
import org.example.exception.ResumeNotFoundException;
import org.example.model.Resume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListStorageTest {

  private Storage storage;

  private static final String UUID_1 = "uuid1";
  private static final Resume R1 = new Resume(UUID_1);

  private static final String UUID_2 = "uuid2";
  private static final Resume R2 = new Resume(UUID_2);

  private static final String MISSING = "missing";

  @BeforeEach
  void setUp() {
    storage = new ListStorage();
    storage.save(R1);
  }

  @Test
  void save_whenStorageEmpty_savesResume() {
    storage.clear();

    storage.save(R1);

    assertSame(R1, storage.get(UUID_1));
    assertEquals(1, storage.size());
  }

  @Test
  void save_whenStorageNotEmpty_savesResume() {
    storage.save(R2);

    assertSame(R2, storage.get(UUID_2));
    assertEquals(2, storage.size());
  }

  @Test
  void save_whenResumeExists_throwsResumeAlreadyExists() {
    assertThrows(ResumeAlreadyExistsException.class, () -> storage.save(new Resume(UUID_1)));
  }

  @Test
  void get_whenResumeExists_returnsResume() {
    assertSame(R1, storage.get(UUID_1));
  }

  @Test
  void get_whenNotFound_throwsResumeNotFound() {
    assertThrows(ResumeNotFoundException.class, () -> storage.get(MISSING));
  }

  @Test
  void update_whenResumeExists_updatesResume() {
    Resume updated = new Resume(UUID_1);

    storage.update(updated);

    assertSame(updated, storage.get(UUID_1));
    assertEquals(1, storage.size());
  }

  @Test
  void update_whenNotFound_throwsResumeNotFound() {
    assertThrows(ResumeNotFoundException.class, () -> storage.update(new Resume(MISSING)));
  }

  @Test
  void delete_whenResumeExists_deletesResume() {
    storage.delete(UUID_1);

    assertThrows(ResumeNotFoundException.class, () -> storage.get(UUID_1));
    assertEquals(0, storage.size());
  }

  @Test
  void delete_whenNotFound_throwsResumeNotFound() {
    assertThrows(ResumeNotFoundException.class, () -> storage.delete(MISSING));
  }

  @Test
  void size_whenStorageNotEmpty_returnsSize() {
    assertEquals(1, storage.size());

    storage.delete(UUID_1);

    assertEquals(0, storage.size());
  }

  @Test
  void getAll_whenStorageNotEmpty_returnsAllResumes() {
    assertArrayEquals(new Resume[] {R1}, storage.getAll());

    storage.save(R2);

    assertArrayEquals(new Resume[] {R1, R2}, storage.getAll());
  }

  @Test
  void clear_whenStorageNotEmpty_clearsStorage() {
    storage.save(R2);

    storage.clear();

    assertEquals(0, storage.size());
    assertArrayEquals(new Resume[0], storage.getAll());
    assertThrows(ResumeNotFoundException.class, () -> storage.get(UUID_1));
  }
}
