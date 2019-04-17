package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

/**
 * MapResumeStorage.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 17.04.2019.
 */

public class MapResumeStorage extends AbstractStorage<Resume> {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected Resume getSearchKey(String resume) {
        return map.get(resume);
    }

    @Override
    protected void doUpdate(Resume r, Resume resume) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected boolean isExist(Resume resume) {
        return resume != null;
    }

    @Override
    protected void doSave(Resume r, Resume key) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Resume resume) {
        return resume;
    }

    @Override
    protected void doDelete(Resume resume) {
        map.remove(resume.getUuid());
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }
}
