package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 *
 * @author Artur Glyzin.
 * @version 3.0.
 * @since 22.03.2019.
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    /**
     * Removes all of the resumes from this storage.
     */

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    /**
     * Add resume to storage.
     *
     * @param r - resume.
     */

    public void save(Resume r) {
        storage[size++] = r;
    }

    /**
     * Returns a resume.
     *
     * @param uuid - uuid resume.
     * @return Resume.
     */

    public Resume get(String uuid) {
        for (Resume r : getAll()) {
            if (r.getUuid().equals(uuid)) {
                return r;
            }
        }
        return null;
    }

    /**
     * Remove resume from storage.
     *
     * @param uuid - id resume.
     */

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                System.arraycopy(storage, i + 1, storage, i, size - 1 - i);
                storage[size - 1] = null;
                size--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    /**
     * Returns the number of elements.
     *
     * @return size.
     */

    public int size() {
        return size;
    }
}
