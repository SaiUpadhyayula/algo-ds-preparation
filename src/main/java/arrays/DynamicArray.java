package arrays;

import exception.ElementNotFoundException;

public class DynamicArray<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] arr;
    private int index;
    private int size;

    public DynamicArray() {
        arr = new Object[DEFAULT_CAPACITY];
        index = 0;
        size = 0;
    }

    public T add(T element) {
        ensureCapacity();
        arr[index++] = element;
        size++;
        return element;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        T element = (T) arr[index];
        if (element == null) {
            throw new ElementNotFoundException();
        }
        return element;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return arr.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T set(int index, T element) {
        arr[index] = element;
        return element;
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        T toRemove = (T) arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = null;
        size--;
        return toRemove;
    }

    private void ensureCapacity() {
        if (index == arr.length - 1) {
            Object[] newArr = new Object[DEFAULT_CAPACITY + (DEFAULT_CAPACITY >> 1)];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
    }
}
