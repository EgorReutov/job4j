package ru.job4j.generic;

public class AbstractStore<T extends Base> implements Store<T> {
    private int size;
    private static final int DEFAULT_SIZE = 10;
    SimpleArray<T> array;

    public AbstractStore() {
        this(DEFAULT_SIZE);
    }

    public AbstractStore(int size) {
        this.size = size;
        array = new SimpleArray<>(size);
    }

    @Override
    public void add(T model) {
        array.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = getIndex(id);
        if (index == -1) {
            throw new RuntimeException();
        }
        array.set(index, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        int index = getIndex(id);
        if (index == -1) {
            throw new RuntimeException();
        }
        array.delete(index);
        return true;
    }

    @Override
    public T findById(String id) {
        T result = null;
        for (T temp : array) {
            if (temp.getId().equals(id)) {
                result = temp;
                break;
            }
        }
        return result;
    }

    public int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < array.getSize(); i++) {
            if (array.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
