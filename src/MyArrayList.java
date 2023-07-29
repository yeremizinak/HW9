import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArrayList<V> {
        private Object[] objects = new Object[10];
        private int index = 0;

        public void add(V value){
            rebalance();
            objects[index] = value;
            index++;
        }

    public V remove(int index){
        if (checkIndex(index)) {
            Object[] newArray =  new Object[objects.length-1];
            for(int i=0;i<newArray.length;i++){
                if(i==index){
                    break;
                } else {
                    newArray[i] = objects[i];
                }
            }
            index--;
            return (V) newArray;
        } else {
            throw new IndexOutOfBoundsException("You entered invalid index");
        }
    }

        public void clear(){
            for(int i=0;i< objects.length;i++){
                objects[i]=null;
            }
            index = 0;
        }

        public int size(){
            return index;
        }

        public V get(int index) {
            if (checkIndex(index)) {
                return (V) objects[index];
            } else {
                throw new IndexOutOfBoundsException("You entered invalid index");
            }
        }
        public void rebalance(){
            if(objects.length-1 == index){
                objects = Arrays.copyOf(objects,objects.length*2);
            }
        }
        public boolean checkIndex(int index){
                return index<= objects.length-1 && index>=0;
        }
    }
