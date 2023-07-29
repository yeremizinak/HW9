import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

public class MyStack<V> {
    private Object[] objects = new Object[10];
    int size =0;

    public void push(V value){
        checkLength();
        objects[size] = value;
        size++;
    }

    public V remove(int index) {
        if (checkIndex(index)) {
            Object[] newArray = new Object[objects.length - 1];
            for (int i = 0; i < newArray.length; i++) {
                if (i == index) {
                    break;
                } else {
                    newArray[i] = objects[i];
                }
            }
            size--;
            return (V) newArray;
        } else {
            throw new IndexOutOfBoundsException("You entered invalid index");
        }
    }

    public void clear(){
        size = 0;
        Object[] objects = new Object[0];
    }

    public int size(){
        return size;
    }

    public V peek(){
        return (V) objects[objects.length-1];
    }

    public V pop(){
        Object[] newArray =  new Object[objects.length-1];
        for(int i=0;i<newArray.length;i++){
            newArray[i] = objects[i];
        }
        size--;
        return (V) newArray;
    }

    public void checkLength(){
        if(objects.length-1 == size){
            objects = Arrays.copyOf(objects,objects.length+5);
        }
    }
    public boolean checkIndex(int index){
        return index>=0 && index<size;
    }
}
