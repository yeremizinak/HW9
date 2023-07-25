public class Node<V> {
    public Node<V> prevNode;
    public Node<V> nextNode;
    private V value;

    public Node(Node<V> prevNode, Node<V> nextNode, V value) {
        this.prevNode = prevNode;
        this.nextNode = nextNode;
        this.value = value;
    }

    public Node<V> getPrevNode() {
        return prevNode;
    }

    public Node<V> getNextNode() {
        return nextNode;
    }

    public V getValue() {
        return value;
    }

    public void setPrevNode(Node<V> prevNode) {
        this.prevNode = prevNode;
    }

    public void setNextNode(Node<V> nextNode) {
        this.nextNode = nextNode;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
