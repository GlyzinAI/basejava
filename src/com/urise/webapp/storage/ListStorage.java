package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    protected List<Resume> resumes = new ArrayList<>();

    @Override
    public int size() {
        return resumes.size();
    }

    @Override
    public void clear() {
        resumes.clear();

    }

    @Override
    public void save(Resume r) {
        resumes.add(r);
    }

    @Override
    public void update(Resume r) {

    }

    @Override
    public Resume get(String uuid) {
        return null;
    }

    @Override
    public void delete(String uuid) {

    }
}
