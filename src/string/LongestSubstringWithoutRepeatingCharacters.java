package string;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, curLen = 0, startIndex = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.getOrDefault(c, -1) < startIndex) {
                map.put(c, i);
                curLen++;
            }
            else {
                startIndex = map.get(c) + 1;
                curLen = i - startIndex + 1;
                map.put(c, i);
            }
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }
}
