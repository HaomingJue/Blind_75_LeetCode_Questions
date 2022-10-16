package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> memo = new HashMap<>();
        for (String str : strs) {
            char[] keyArray = str.toCharArray();
            Arrays.sort(keyArray);
            String anagram = "";
            for (char c : keyArray) {
                anagram += c;
            }
            if (memo.containsKey(anagram)) {
                memo.get(anagram).add(str);
            }
            else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                memo.put(anagram, list);
            }
        }
        for (String key : memo.keySet()) {
            ans.add(memo.get(key));
        }
        return ans;
    }
}
