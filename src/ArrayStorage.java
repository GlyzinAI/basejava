import java.util.Arrays;

/**
 * Array based storage for Resumes
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 22.03.2019.
 */
public class ArrayStorage {
    private int index;
    private int size;

    /**
     * Resume storage.
     */

    Resume[] storage = new Resume[10000];

    /**
     * Clear storage
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
        this.storage[index++] = r;
        size++;
    }

    /**
     * Returns a resume.
     *
     * @param uuid - uuid resume.
     * @return Resume.
     */

    Resume get(String uuid) {
        Resume resume = new Resume();
        resume.uuid = "В базе нет резюме с таким uuid, пожалуйста введите корректный uuid.";
        for (Resume r : getAll()) {
            if (r.uuid.equals(uuid)) {
                resume = r;
                break;
            }
        }
        return resume;
    }

    /**
     * Remove resume from storage.
     *
     * @param uuid
     */

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i] != null && storage[i].uuid.equals(uuid)) {
                System.arraycopy(storage, i + 1, storage, i, storage.length - 1 - i);
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
        return this.size;
    }
}
