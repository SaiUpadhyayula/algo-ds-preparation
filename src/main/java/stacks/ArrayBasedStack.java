package stacks;

class ArrayBasedStack<T> {

    private final T[] data;
    private final int size;
    private int index;

    ArrayBasedStack(int size) {
        this.size = size;
        this.data = (T[]) new Object[size];
    }

    void push(T element) {
        if (index == size)
            throw new IllegalArgumentException("Stack is full");
        data[index++] = element;
    }

    boolean isEmpty() {
        return index == 0;
    }

    int size(){
        return index;
    }

    T pop() {
        if (index == 0) throw new IllegalArgumentException("Stack is Empty");
        T elementToPop = data[index - 1];
        data[index - 1] = null;
        index--;
        return elementToPop;
    }

    T peek() {
        return data[index-1];
    }
}
