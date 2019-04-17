package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * AbstractArrayStorage
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 17.04.2019.
 */

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void doSave(Resume r, Integer index) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            insertElement(r, index);
            size++;
        }
    }

    @Override
    protected void doDelete(Integer index) {
        fillDeletedElement(index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected Resume doGet(Integer index) {
        return storage[index];
    }

    @Override
    protected void doUpdate(Resume r, Integer index) {
        storage[index] = r;
    }

    @Override
    protected boolean isExist(Integer index) {
        return index >= 0;
    }

    @Override
    public List<Resume> doCopyAll() {
        Resume[] r = Arrays.copyOfRange(storage, 0, size);
        return new ArrayList<>(Arrays.asList(r));
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume r, int index);

    protected abstract Integer getSearchKey(String uuid);
}
