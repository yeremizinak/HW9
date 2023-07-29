import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.HashMap;

public class MyHashMap <K, V> {
    int size = 0;
    private static final int DEFAULT_CAPACITY = 16;
    HashNode<K,V>[] table = (HashNode<K, V>[]) new Object[DEFAULT_CAPACITY];


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
        HashNode node = new HashNode(key,value);
        int index = getIndexTable(key);

        if(table[index] == null){
            table[index] = node;
        } else {
            HashNode currentNode = table[index];
            HashNode prevNode = null;
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
        HashNode currentNode = table[index];
        HashNode prevNode = null;

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
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    public void clear(){
        for(int i=0; i<table.length;i++){
            table[i] = null;
        }
        size = 0;
    }

    public V get(K key){
        int index = getIndexTable(key);
        HashNode currentNode = table[index];

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
            table = Arrays.copyOf(table,table.length*2);
        }
    }
}
