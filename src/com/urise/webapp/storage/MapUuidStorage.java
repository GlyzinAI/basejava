package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * MapUuidStorage
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 04.04.2019.
 */

public class MapUuidStorage extends AbstractStorage {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        Set<String> keys = map.keySet();
        for (String key : keys) {
            return key;
        }
        return null;
    }

    @Override
    protected void doUpdate(Resume r, Object key) {
        map.put(key.toString(), r);
    }

    @Override
    protected boolean isExist(Object key) {
        return false;
    }

    @Override
    protected void doSave(Resume r, Object key) {
        map.put(key.toString(), r);
    }

    @Override
    protected Resume doGet(Object key) {
        return map.get(key.toString());
    }

    @Override
    protected void doDelete(Object key) {
        map.remove(key.toString());
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public List<Resume> getAllSorted() {
        return null;
    }
}
