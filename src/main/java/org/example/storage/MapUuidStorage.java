package org.example.storage;

import org.example.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage<String> {

    private final Map<String, Resume> map = new HashMap<>();

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    protected boolean exists(String searchKey) {
        return searchKey != null;
    }

    @Override
    protected void doSave(String searchKey, Resume r) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(String searchKey) {
        return map.get(searchKey);
    }

    @Override
    protected void doUpdate(String searchKey, Resume r) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(String searchKey) {
        map.remove(searchKey);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return map.containsKey(uuid) ? uuid : null;
    }

    @Override
    protected List<Resume> getAllAsList() {
        return new ArrayList<>(map.values());
    }
}
