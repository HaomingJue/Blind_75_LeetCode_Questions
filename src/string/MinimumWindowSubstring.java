package string;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return null;
        }
        String ans = "";
        int minLen = Integer.MAX_VALUE, left = 0, count = 0;
        int[] countLetter = new int[128];
        for (int i = 0; i < t.length(); i++) {
            countLetter[t.charAt(i)]++;
        }
        for (int right = 0; right < s.length(); right++) {
            countLetter[s.charAt(right)]--;
            if (countLetter[s.charAt(right)] >= 0) {
                count++;
            }
            while (count == t.length()) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    ans = s.substring(left, right+1);
                }
                countLetter[s.charAt(left)]++;
                if (countLetter[s.charAt(left)] > 0) {
                    count--;
                }
                left++;
            }
        }
        return ans;
    }
}
