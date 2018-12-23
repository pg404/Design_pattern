package data_structure_and_algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm.leetcode
 * Author:Alan Ruan
 * Date:2018-12-11 14:24
 * Description://TODO  Given a List of words, return the words that can be typed using letters of alphabet
 * on only one row's of American keyboard like the image below.
 *
 * Example:
 *
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 *
 */
public class KeyboardRow_500 {

    public static void main(String[] args) {
        String[] strings = {"fsad","ivadhiih","vbxmb","rewr","uhbji","iiij"};
        String[] temp = findWords(strings);
        for (String s: temp){
            System.out.println(s);
        }
    }

    public static String[] findWords(String[] words) {

        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++){
            for(char c: strs[i].toCharArray()){
                //put <char, rowIndex> pair into the map
                map.put(c, i);
            }
        }

        List<String> res = new LinkedList<>();

        for(String w: words){
            if(w.equals(""))
            {
                continue;
            }
            int index = map.get(w.toUpperCase().charAt(0));

            for(char c: w.toUpperCase().toCharArray()){
                if(map.get(c)!=index){
                    //don't need a boolean flag.
                    index = -1;
                    break;
                }
            }
            if(index!=-1)
            {
                //if index != -1, this is a valid string
                res.add(w);
            }
        }
        return res.toArray(new String[0]);
    }
}
