import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MyQueue<V> {
    int queueLength = 10;
    private Object[] objects = new Object[queueLength];
    private int size = 0;
    private int begin = 0;
    private int end = -1;

    public void add(V value) {
        if (size == objects.length) {
            queueLengthMore();
        }
        end = (end + 1) % objects.length;
        objects[end] = value;
        size++;
    }

    public void clear() {
        size = 0;
        begin = 0;
        end = -1;
    }

    public int size() {
        return size;
    }

    public V peek() {
        if (size == 0) {
            throw new IllegalStateException("Size of queue is 0");
        }
        return (V) objects[begin];
    }

    public V poll() {
        if (size == 0) {
            throw new IllegalStateException("Size of queue is 0");
        }
        Object element = objects[begin];
        begin = (begin + 1) % objects.length;
        size--;
        return (V) element;
    }

    private void queueLengthMore() {
        int newLength = objects.length * 2;
        Object[] newQueueArray = new Object[newLength];
        for (int i = 0; i < size; i++) {
            newQueueArray[i] = objects[(begin + i) % objects.length];
        }
        objects = newQueueArray;
        begin = 0;
        end = size - 1;
    }
}
