package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public abstract class AbstractArrayStorageTest {
    private Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() {
        assertEquals(3, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void get() {
        assertEquals(new Resume(UUID_2), storage.get(UUID_2));
        storage.get("uuid4");
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void getAll() {
        Resume[] allElements = storage.getAll();
        assertEquals(3, allElements.length);
        assertEquals(new Resume(UUID_1), allElements[0]);
        assertEquals(new Resume(UUID_2), allElements[1]);
        assertEquals(new Resume(UUID_3), allElements[2]);
    }

    @Test(expected = NotExistStorageException.class)
    public void update() {
        storage.update(new Resume("dummy"));
        storage.update(new Resume(UUID_2));
    }

    @Test(expected = ExistStorageException.class)
    public void save() {
        Resume resume = new Resume("uuid4");
        storage.save(resume);
        assertEquals(4, storage.size());
        assertEquals(resume, storage.get("uuid4"));
        storage.save(new Resume(UUID_2));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_3);
        assertEquals(2, storage.size());
        storage.get(UUID_3);
        storage.delete("uuid5");
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test(expected = StorageException.class)
    public void checkOverflowArray() {
        try {
            for (int i = 0; i < 9997; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            fail();
        } finally {
            storage.save(new Resume());
        }
    }
}