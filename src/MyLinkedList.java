import java.util.LinkedList;
import java.util.List;

public class MyLinkedList<V> {

    private Node<V> firstNode;
    private Node<V> lastNode;
    int size = 0;

    public void add(V value) {
        if (firstNode == null) {
            firstNode = new Node<>(null, null, value);
        } else if (lastNode == null) {
            lastNode = new Node<>(firstNode, null, value);
            firstNode.setNextNode(lastNode);
        } else {
            Node<V> node = new Node<>(lastNode, null, value);
            lastNode.setNextNode(node);
            lastNode = node;
        }
        size++;
    }

    public void remove(int index) {
        if (checkIndex(index)) {
            if (index == 0) {
                firstNode = firstNode.getNextNode();
                firstNode.prevNode = null;
            } else if (index == size - 1) {
                lastNode = lastNode.getPrevNode();
                lastNode.nextNode = null;
            } else {
                Node<V> currentNode = firstNode;
                for (int i = 0; i < index; i++) {
                    currentNode = currentNode.nextNode;
                }
                currentNode.prevNode.nextNode = currentNode.nextNode;
                currentNode.nextNode.prevNode = currentNode.prevNode;
            }
            size--;
        } else {
            throw new IllegalStateException("You entered invalid index");
        }
    }

    public void clear() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    public V get(int index) {
        if (checkIndex(index)) {
            Node<V> currentNode = firstNode;
            if (index == 0) {
                return currentNode.getValue();
            }
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNextNode();
            }
            return currentNode.getValue();
        } else {
            throw new IllegalStateException("You entered invalid index");
        }
    }

    public int size() {
        return size;
    }

    public boolean checkIndex(int index) {
        return index >= 0 && index < size;
    }

}
