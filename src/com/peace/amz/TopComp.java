package com.peace.amz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Tenho uma lista nome de competidores e um inteiro com o numero de competidores
 * Uma lista de string contendo reviews e um inteiro com o numero de strings
 * Tenho o top N competidores que devo retornar
 * 
 * Contar numero de vezes que um competidor aparece numa review (se aparecer mais de 1 vez, contar apenas uma)
 * Ordenar por quantidade de vezes que um competidor apareceu numa review
 * Retornar os top N competidores
 */

class TopComp {
    ArrayList<String> topNComp(int numCompetitors, int topNCompetitors, ArrayList<String> competitors, int numReviews,
            ArrayList<String> reviews) {
        // lista dos top n competidores
        ArrayList<String> ret = new ArrayList<>();

        // for each review in reviews
        HashMap<String, Integer> map = new HashMap<>();
        for (String review : reviews) {
            // for each word in review
            String[] words = review.split(" ");
            HashSet<String> set = new HashSet<>();
            for (String word : words) {
                // if word is a compertitor, insert into set to avoid duplicates
                for (String competitor : competitors) {
                    if (word.equals(competitor)) {
                        set.add(word);
                    }
                }
            }

            // increment key into map if it was found in the review
            for (String comp : set) {
                Integer value = map.get(comp);
                if (value != null) {
                    map.put(comp, value + 1);
                } else {
                    map.put(comp, 1);
                }
            }
        }

        // sort hashmap by value

        // treemap sort by key at insertion, but I want by value

        // convert map to list of entries to sort by value using custom comparator
        LinkedList<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        // go over sorted list and insert into a map that keeps order of insertion
        /**
         * LinkedHashMap<String, Integer> staticmap = new LinkedHashMap<>(); for
         * (Map.Entry<String, Integer> entry : list) { staticmap.put(entry.getKey(),
         * entry.getValue()); }
         */

        // or just add top n to list of strings
        for (int i = 0; i < topNCompetitors; i++) {
            ret.add(list.get(i).getKey());
        }

        return ret;
    }

    public static void main(String[] args) {
        // declara and initialize input
        ArrayList<String> competitors = new ArrayList<>();
        competitors.add("Microsoft"); // 2
        competitors.add("HP"); // 6
        competitors.add("Apple"); // 1
        competitors.add("IBM");

        ArrayList<String> reviews = new ArrayList<>();
        reviews.add("Adajiso idj fdsfiojfs Microsoft riowejr irejw HP fsdj HP fijs HP");
        reviews.add("Adajiso idj fdsfiojfs HP riowejr irejw HP fsdj HP fijs HP");
        reviews.add("Adajiso idj fdsfiojfs HP riowejr irejw HP fsdj HP fijs HP");
        reviews.add("Adajiso idj fdsfiojfs HP riowejr irejw HP fsdj HP fijs HP");
        reviews.add("Adajiso idj fdsfiojfs Microsoft riowejr irejw HP fsdj HP fijs HP");
        reviews.add("Adajiso idj fdsfiojfs Apple riowejr irejw HP fsdj HP fijs HP");

        // solve
        ArrayList<String> topn = new TopComp().topNComp(4, 2, competitors, 4, reviews);

        // imprime output
        for (String top : topn) {
            System.out.println(top);
        }
    }
}
