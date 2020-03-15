package src.com.peace.collection;

class Map {

    void hashmap() {
        // not keep order
        // array of buckets pointing to a linked list

        java.util.Map<String, Integer> map = new java.util.HashMap<>();

        map.put("gold", 50);
        map.put("stone", 100);
        map.put("wood", 250);
        map.put("plastic", 500);
        map.put("oil", 1000);

        Boolean b;
        b = map.containsKey("gold");
        System.out.println("Contains gold? " + b); // true

        b = map.containsKey("Gold");
        System.out.println("Contains Gold? " + b); // false

        int wood;
        wood = map.get("wood");
        System.out.println("Wood: " + wood); // 250

        // replace wood value
        map.put("wood", map.get("wood") + 500);
        wood = map.get("wood");
        System.out.println("Wood after update: " + wood); // 750

        // int woodd = map.get("woodd");
        // System.out.println("Woodd: " + woodd); // null pointer exception

        // char array as key
        char[] k = "stone".toCharArray(); // String to char array
        int stone = map.get(new String(k)); // Char array to string
        System.out.println("Stone: " + stone); // 100

        // iterate keys
        for (String key : map.keySet()) {
            System.out.println("Key: " + key);
            System.out.println("Value: " + map.get(key));
        }
        System.out.println(".");

        // remove
        map.remove("oill"); // no exception when the key is invalid

        map.remove("oil"); // no exception when the key is invalid

        // iterate Entry
        for (java.util.Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println("Key: " + e.getKey());
            System.out.println("Value: " + e.getValue());
            System.out.println("Entry.toString(): " + e.toString()); // stone=100
        }

        String setence = "The sun is nice outside but not as nice as the sun of the mountain.";
        java.util.Map<Character, Integer> counter = new java.util.HashMap<>();
        for (char c : setence.toCharArray()) {
            if (counter.containsKey(c)) {
                int v = counter.get(c);
                counter.put(c, v + 1);
            } else {
                counter.put(c, 1);
            }
        }
        // print <key,value>
        for (java.util.Map.Entry<Character, Integer> e : counter.entrySet()) {
            System.out.println("" + e.getKey() + ": " + e.getValue());
        }
        // sort hashmap by value desc (no collection method available)
        // LinkedHashMap garantee to keep insertion order
        // TreeMap is not useful bc it sorts by key at each insertion, but not by value
        java.util.List<java.util.Map.Entry<Character, Integer>> entries = new java.util.ArrayList<>(counter.entrySet());
        java.util.Collections.sort(entries, new java.util.Comparator<java.util.Map.Entry<Character, Integer>>() {
            @Override
            public int compare(java.util.Map.Entry<Character, Integer> o1, java.util.Map.Entry<Character, Integer> o2) {
                // return o2.getValue().compareTo(o1.getValue()); // bigger to small
                return o2.getValue() - o1.getValue(); // bigger to small
            }
        });
        java.util.Map<Character, Integer> sortedMap = new java.util.LinkedHashMap<>();
        for (java.util.Map.Entry<Character, Integer> e : entries) {
            sortedMap.put(e.getKey(), e.getValue());
        }
        System.out.println(sortedMap);
    }

    void treemap() {
        // sort by key value at each insertion
        // 
    }
    public static void main(String args[]) {
        
    }
}