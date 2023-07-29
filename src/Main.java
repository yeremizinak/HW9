import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random random = new Random();
        MyArrayList<String> arrayList = new MyArrayList();
        MyLinkedList<String> linkedList = new MyLinkedList();
        MyQueue<Integer> queue = new MyQueue();
        MyStack<String> stack = new MyStack();
        MyHashMap<Integer,String> hashMap = new MyHashMap();

        int countElements = 1000001;

        for(int i=0;i<countElements;i++){
            arrayList.add("Element #" + i);
            linkedList.add("Element #" + i);
            queue.add(i);
            stack.push("Element #" + i);
            hashMap.put(i,"Element #" + i);
        }
        System.out.println("Current size of an array is " + arrayList.size() + ". Got a random element of an array: " + arrayList.get(random.nextInt()) + arrayList.remove(random.nextInt()) + ". Removed a random element of an array and got a new size: " + arrayList.size() + ".");

        System.out.println("Current size of an array is " + linkedList.size() + ". Got a random element of an array: " + linkedList.get(random.nextInt()));
        linkedList.remove(random.nextInt());
        System.out.println(". Removed a random element of an array and got a new size: " + linkedList.size() + ".");

        System.out.println("Current size of the queue is " + queue.size() + ". The first element of the queue is " + queue.poll() + ". So now the first element is " + queue.peek() + ". The new size of the queue is " + queue.size());

        System.out.println("Current size of an array is " + stack.size() + ". First element and the deleted: " + stack.pop() + ". Removed a random element of an array and got a new size: ");
        stack.remove(random.nextInt());
        System.out.print(stack.size() + ". The new first element now is " + stack.peek());

        int key = random.nextInt();
        int keyTwo = random.nextInt();
        System.out.println("Current size of collection is " + hashMap.size() + "The value for the " + key + "key is " + hashMap.get(key));
        hashMap.remove(keyTwo);
        System.out.print(". Removed random pair by " + keyTwo + "key and got a new size of the collection: " + hashMap.size());

        arrayList.clear();
        linkedList.clear();
        queue.clear();
        stack.clear();
        hashMap.clear();

        System.out.println("Cleared everything. New sizes: arrayList - " + arrayList.size() + "\n linkedList - " + linkedList.size() + "\n queue - " + queue.size() + "\n stack - " + stack.size() + "\n hashMap - " + hashMap.size());
    }
}
