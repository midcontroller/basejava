package org.example.storage;

import static org.example.ResumeTestData.createResume;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.example.exception.ResumeAlreadyExistsException;
import org.example.exception.ResumeNotFoundException;
import org.example.model.Resume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstractStorageTest {

    protected static final String UUID_1 = "UUID_1";
    protected static final String UUID_2 = "UUID_2";
    protected static final String UUID_3 = "UUID_3";
    protected static final String UUID_4 = "UUID_4";
    protected static final String UUID_5 = "UUID_5";
    protected static final String MISSING = "missing";
    protected static final Resume R1 = createResume("UUID_1", "Григорий Кислин");
    protected static final Resume R2 = createResume("UUID_2", "Д Д");
    protected static final Resume R3 = createResume("UUID_3", "Е Е");
    protected static final Resume R4 = createResume("UUID_4", "Ж Ж");
    protected static final Resume R5 = createResume("UUID_5", "З З");
    protected final Storage storage;

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    void setUp() {
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
        storage.save(R4);
    }

    @Test
    void save_whenStorageEmpty_savesResume() {
        storage.clear();
        storage.save(R1);
        assertEquals(R1, storage.get(UUID_1));
    }

    @Test
    void save_whenStorageNotEmpty_savesResume() {
        storage.save(R5);
        assertEquals(R5, storage.get(UUID_5));
    }

    @Test
    void save_whenResumeExists_throwsResumeAlreadyExistsException() {
        assertThrows(ResumeAlreadyExistsException.class, () -> storage.save(R1));
    }

    @Test
    void get_whenResumeExists_returnResume() {
        Resume actual = storage.get(UUID_1);
        assertEquals(R1, actual);
    }

    @Test
    void get_whenResumeNotExists_throwsResumeNotFoundException() {
        assertThrows(ResumeNotFoundException.class, () -> storage.get(MISSING));
    }

    @Test
    void update_whenResumeExists_updatedResume() {
        Resume updated = new Resume(UUID_1);

        storage.update(updated);

        assertEquals(updated, storage.get(UUID_1));
    }

    @Test
    void update_whenResumeNotExists_throwsResumeNotFoundException() {
        Resume updated = new Resume(MISSING);
        assertThrows(ResumeNotFoundException.class, () -> storage.update(updated));
    }

    @Test
    void delete_whenResumeExists_deletedResume() {
        storage.delete(UUID_1);
        assertThrows(ResumeNotFoundException.class, () -> storage.get(UUID_1));
    }

    @Test
    void delete_whenResumeNotExists_throwsResumeNotFoundException() {
        assertThrows(ResumeNotFoundException.class, () -> storage.delete(MISSING));
    }

    @Test
    void size_whenStorageNotEmpty_returnsSize() {
        assertEquals(4, storage.size());
    }

    @Test
    void getAll_whenStorageNotEmpty_returnsAllResumes() {
        assertIterableEquals(Arrays.asList(R1, R2, R3, R4), storage.getAllSorted());
    }

    @Test
    void clear_whenStorageNotEmpty_clearsStorage() {
        assertEquals(4, storage.size());
        storage.clear();
        assertIterableEquals(List.of(), storage.getAllSorted());
        assertEquals(0, storage.size());
    }
}
