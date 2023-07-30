import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.HashMap;

public class MyHashMap <K, V> {
    int size = 0;
    private static final int DEFAULT_CAPACITY = 16;
    HashNode<K,V>[] table = (HashNode<K, V>[]) new HashNode[DEFAULT_CAPACITY];


    private int getIndexTable(K key){
        if(key == null){
            return 0;
        } else{
            int hashCode = key.hashCode();
            return hashCode%table.length;
        }
    }

    public int size(){
        return size;
    }

    public void put(K key, V value){
        rebalance();
        HashNode<K,V> node = new HashNode<>(key,value);
        int index = getIndexTable(key);

        if(table[index] == null){
            table[index] = node;
        } else {
            HashNode<K,V> currentNode = table[index];
            HashNode<K,V> prevNode = null;
            while (currentNode != null) {
                if (currentNode.key.equals(key)) {
                    currentNode.value = value;
                    return;
                }
                prevNode = currentNode;
                currentNode = currentNode.next;
            }

            prevNode.next = node;
        }
        size++;
    }

    public void remove(K key){
        int index = getIndexTable(key);
        HashNode<K,V> currentNode = table[index];
        HashNode<K,V> prevNode = null;

        if(table[index] == null){
            throw new IllegalStateException("Nothing to remove");
        } else {
            while(currentNode != null){
                if(currentNode.key.equals(key)){
                    if(prevNode == null){
                        table[index] = currentNode.next;
                    } else {
                        prevNode.next = currentNode.next;
                    }
                    size--;
                    return;
                }
            }
            //prevNode = currentNode;
            //currentNode = currentNode.next;
        }
    }

    public void clear(){
        table = new HashNode[0];
        size = 0;
    }

    public V get(K key){
        int index = getIndexTable(key);
        HashNode<K,V> currentNode = table[index];

        if(table[index] == null){
            throw new IllegalStateException("Nothing to remove");
        } else {
            while(currentNode != null){
                if(currentNode.key.equals(key)){
                    return (V)currentNode.value;
                }
                currentNode = currentNode.next;
            }

        }
        return null;
    }

    public void rebalance(){
        if(table.length-1 == size){
            int newDefCapacity = table.length * 2;
            HashNode<K, V>[] newTable = new HashNode[newDefCapacity];
            for (HashNode<K, V> node : table) {
                while (node != null) {
                    int newIndex = getIndexTable(node.key);
                    HashNode<K, V> nextNode = node.next;
                    node.next = newTable[newIndex];
                    newTable[newIndex] = node;
                    node = nextNode;
                }
            }
            table = newTable;
        }
    }
}
