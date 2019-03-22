import java.util.Arrays;

/**
 * Array based storage for Resumes
 *
 * @author Artur Glyzin.
 * @version 3.0.
 * @since 22.03.2019.
 */
public class ArrayStorage {
    private int size;

    Resume[] storage = new Resume[10000];

    /**
     * Removes all of the resumes from this storage.
     */

    void clear() {
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

    void save(Resume r) {
        storage[size++] = r;
    }

    /**
     * Returns a resume.
     *
     * @param uuid - uuid resume.
     * @return Resume.
     */

    Resume get(String uuid) {
        for (Resume r : getAll()) {
            if (r.uuid.equals(uuid)) {
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

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
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

    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    /**
     * Returns the number of elements.
     *
     * @return size.
     */

    int size() {
        return size;
    }
}
