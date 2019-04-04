package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * MapStorage
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 04.04.2019.
 */

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> map = new HashMap<>(10000);

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(Resume r, Object key) {
        map.put((String) key, r);
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

    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume[] getAll() {
        Collection<Resume> values = map.values();

        return values.toArray(new Resume[values.size()]);
    }

    @Override
    public int size() {
        return map.size();
    }
}
