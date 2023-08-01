import java.util.Objects;

public class HashNode<K, V> {
    final K key;
    V value;
    HashNode<K, V> next;

    HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public final K getKey() {
        return key;
    }

    public final V getValue() {
        return value;
    }
    //public final String toString() { return key + "=" + value; }

    public final V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashNode<?, ?> hashNode = (HashNode<?, ?>) o;
        return Objects.equals(key, hashNode.key) && Objects.equals(value, hashNode.value) && Objects.equals(next, hashNode.next);
    }*/
}
