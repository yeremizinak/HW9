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
            Object[] newArray =  new Object[objects.length-1];
            for(int i=0;i<newArray.length;i++){
                if(i==index){
                    break;
                } else {
                    newArray[i] = objects[i];
                }
            }
            return (V) newArray;
        }

        public V clear(){
            for(int i=0;i< objects.length;i++){
                objects[i]=null;
            }
            return (V)objects;
        }

        public int size(){
            return objects.length;
        }

        public V get(int index){
            return (V) objects[index];
        }
        public void rebalance(){
            if(objects.length-1 == index){
                objects = Arrays.copyOf(objects,objects.length+5);
            }
        }
    }
