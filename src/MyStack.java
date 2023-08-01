import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

public class MyStack<V> {
    private V[] objects;
    int size = 0;

    public MyStack() {
        objects = (V[]) new Object[16];
    }

    public void push(V value) {
        checkLength();
        objects[size] = value;
        size++;
    }

    public void remove(int index) {
        if (checkIndex(index)) {
            V toRemove = objects[index];
            for (int i = index; i < index - 1; i++) {
                objects[i] = objects[i + 1];
            }
            objects[index - 1] = null;
            size--;
        } else {
            throw new IndexOutOfBoundsException("You entered invalid index");
        }
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            objects[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public V peek() {
        if (size > 0) {
            return (V) objects[size - 1];
        } else {
            throw new IllegalStateException("size <= 0");
        }
    }

    public V pop() {
        if (size > 0) {
            V value = objects[size - 1];
            objects[size - 1] = null;
            size--;
            return value;
        } else {
            throw new IllegalStateException("size <= 0");
        }
    }

    public void checkLength() {
        if (objects.length - 1 == size) {
            objects = Arrays.copyOf(objects, objects.length * 2);
        }
    }

    public boolean checkIndex(int index) {
        return index >= 0 && index < size;
    }
}
