package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

/**
 * ListStorage
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 17.04.2019.
 */

public class ListStorage extends AbstractStorage<Integer> {

    private List<Resume> list = new ArrayList<>();

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Integer index) {
        return index != null;
    }

    @Override
    protected void doUpdate(Resume r, Integer searchKey) {
        list.set(searchKey, r);
    }

    @Override
    protected void doSave(Resume r, Integer searchKey) {
        list.add(r);
    }

    @Override
    protected Resume doGet(Integer index) {
        return list.get(index);
    }

    @Override
    protected void doDelete(Integer searchKey) {
        list.remove(searchKey.intValue());
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(list);
    }
}
