package question.example.collection;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        // ArrayList
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");

        // LinkedList
        List<String> linkedList = new LinkedList<>();
        linkedList.add("Dog");
        linkedList.add("Cat");

        // Vector
        List<String> vector = new Vector<>();
        vector.add("Red");
        vector.add("Blue");

        // Stack (extends Vector)
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.pop();

        // HashSet - Unordered, no duplicates
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Java");
        hashSet.add("Python");

        // LinkedHashSet - Maintains insertion order
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("One");
        linkedHashSet.add("Two");

        // TreeSet - Sorted, no duplicates
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(2);

        // PriorityQueue - Elements sorted by priority
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(30);
        priorityQueue.add(10);

// ArrayDeque - Double-ended queue
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("Front");
        deque.addLast("Back");

        // HashMap - Unordered
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "One");
        hashMap.put(2, "Two");

// LinkedHashMap - Maintains insertion order
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(3, "Three");
        linkedHashMap.put(4, "Four");

// TreeMap - Sorted by keys
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(10, "Ten");
        treeMap.put(5, "Five");

// Hashtable - Thread-safe, no null key/value
        Map<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(11, "Eleven");


    }
}