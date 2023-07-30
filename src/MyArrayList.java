import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArrayList<V> {
        private V[] objects;
        private int size = 0;

        public MyArrayList(){
            objects = (V[]) new Object[10];
        }

        public void add(V value){
            rebalance();
            objects[size] = value;
            size++;
        }

    public void remove(int index){
        if (checkIndex(index)) {
            V toRemove = objects[index];
            for(int i=index;i<index-1;i++){
                objects[i] = objects[i+1];
            }
            objects[index -1] = null;
            size--;
        } else {
            throw new IndexOutOfBoundsException("You entered invalid index");
        }
    }

        public void clear(){
            for(int i=0;i< objects.length;i++){
                objects[i]=null;
            }
            size = 0;
        }

        public int size(){
            return size;
        }

        public V get(int index) {
            if (checkIndex(index)) {
                return objects[index];
            } else {
                throw new IndexOutOfBoundsException("You entered invalid index");
            }
        }
        public void rebalance(){
            if(objects.length-1 == size){
                objects = Arrays.copyOf(objects,objects.length*2);
            }
        }
        public boolean checkIndex(int index){
                return index<= objects.length-1 && index>=0;
        }
    }
