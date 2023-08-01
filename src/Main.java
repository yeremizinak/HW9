import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        MyQueue<Integer> queue = new MyQueue<>();
        MyStack<Integer> stack = new MyStack<>();
        MyHashMap<Integer, Integer> hashMap = new MyHashMap<>();

        Random random = new Random();

        int countElements = 1000001;

        for (int i = 0; i < countElements; i++) {
            int value = random.nextInt(countElements);
            arrayList.add(value);
            linkedList.add(value);
            queue.add(value);
            stack.push(value);
            hashMap.put(i, value);
        }
        System.out.println("\nARRAYLIST");
        System.out.print("Current size of an array is " + arrayList.size() + ". Got a random element of an array: " + arrayList.get(random.nextInt(countElements)));
        arrayList.remove(random.nextInt(countElements));
        System.out.println(". Removed a random element of an array and got a new size: " + arrayList.size() + ".");

        System.out.println("\nLINKEDLIST");
        System.out.print("Current size of an array is " + linkedList.size() + ". Got a random element of an array: " + linkedList.get(random.nextInt(countElements)));
        linkedList.remove(random.nextInt(countElements));
        System.out.println(". Removed a random element of an array and got a new size: " + linkedList.size() + ".");

        System.out.println("\nQUEUE");
        System.out.println("Current size of the queue is " + queue.size() + ". The first element of the queue is " + queue.poll() + ". After peek() the first element is " + queue.peek() + ". The new size of the queue is " + queue.size());

        System.out.println("\nSTACK");
        System.out.print("Current size of an array is " + stack.size() + ". First element and deleted: " + stack.pop() + ". Removed a random element of an array and got a new size: ");
        stack.remove(random.nextInt(countElements));
        System.out.print(stack.size() + ". The new first element now is " + stack.peek() + "\n");

        System.out.println("\nHASHMAP");
        int key = random.nextInt(countElements);
        int keyTwo = random.nextInt(countElements);
        System.out.print("Current size of collection is " + hashMap.size() + ". The value for the " + key + " key is " + hashMap.get(key));
        hashMap.remove(keyTwo);
        System.out.println(". Removed a random pair by " + keyTwo + " key and got a new size of the collection: " + hashMap.size());

        arrayList.clear();
        linkedList.clear();
        queue.clear();
        stack.clear();
        hashMap.clear();

        System.out.println("Cleared everything. New sizes: \narrayList - " + arrayList.size() + "\nlinkedList - " + linkedList.size() + "\nqueue - " + queue.size() + "\nstack - " + stack.size() + "\nhashMap - " + hashMap.size());
    }
}
