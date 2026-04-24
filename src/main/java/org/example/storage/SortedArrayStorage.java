package org.example.storage;

import org.example.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insert(int index, Resume r) {
        int insertPos = (index < 0) ? ~index : index;
        System.arraycopy(storage, insertPos, storage, insertPos + 1, size - insertPos);
        storage[insertPos] = r;
    }

    @Override
    protected void remove(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        return Arrays.binarySearch(storage, 0, size, new Resume(uuid));
    }
}
