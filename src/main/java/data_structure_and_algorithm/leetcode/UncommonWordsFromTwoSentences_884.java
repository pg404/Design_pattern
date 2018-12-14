package main.java.data_structure_and_algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm.leetcode
 * Author:Alan Ruan
 * Date:2018-12-11 16:03
 * Description://TODO We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
 *
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 *
 * Return a list of all uncommon words.
 *
 * You may return the list in any order.
 *
 * Intuition:
 * No matter how many sentences,
 * uncommon word = words that appears only once
 *
 */
public class UncommonWordsFromTwoSentences_884 {

    public static void main(String[] args) {

        String A = "i like apple";
        String B = "i dont like banana";
        String[] strings = uncommonFromSentences(A, B);
        for (String s: strings){
            System.out.println(s);
        }
    }

    public static String[] uncommonFromSentences(String A, String B) {

        Map<String, Integer> count = new HashMap<>();
        for (String w : (A + " " + B).split(" "))
        {
            count.put(w, count.getOrDefault(w, 0) + 1);
        }
        ArrayList<String> res = new ArrayList<>();
        for (String w : count.keySet())
        {
            if (count.get(w) == 1)
            {
                res.add(w);
            }
        }
        return res.toArray(new String[0]);

    }
}
