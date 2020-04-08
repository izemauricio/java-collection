package com.peace.amz;

import java.util.*;

/*

Input: ["123","321","113","1231","12345","1123"];

Output:
[
    [123, 321]
    [1231, 1123]
    [12345]
]

*/
public class groupAnagram {

    public LinkedList<LinkedList<String>> solve(List<String> inputList) {
        LinkedList<LinkedList<String>> outputList = new LinkedList<LinkedList<String>>();

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : inputList) {
            // sort
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String keyString = String.valueOf(chars);

            // cria uma empty linkedlist caso hashmap nao contem key
            if (!map.containsKey(keyString)) {
                map.put(keyString, new LinkedList<String>());
            }

            // get linkedlist from map using key, insert original string into list
            map.get(keyString).add(str);
        }

        System.out.println(map.values());

        return outputList;
    }

    public static void main(String[] args) {
        List<String> input = new LinkedList<String>();
        input.add("123");
        input.add("321");
        input.add("1234");
        input.add("4321");
        input.add("43211");

        new groupAnagram().solve(input);
    }
}