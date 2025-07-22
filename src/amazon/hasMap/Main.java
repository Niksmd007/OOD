package amazon.hasMap;

import amazon.hasMap.MyHashMap;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);

        System.out.println(map.get("banana")); // 2

        System.out.println("Removing banana: " + map.remove("banana")); // true
        System.out.println("After removal: " + map.get("banana")); // null

        System.out.println("Removing grape: " + map.remove("grape")); // false
    }
}
