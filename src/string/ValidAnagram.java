package string;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] helper = new int[26];
        for (int i = 0; i < s.length(); i++) {
            helper[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            helper[t.charAt(i) - 'a']--;
        }
        for (int a : helper) {
            if (a != 0) return false;
        }
        return true;
    }
}
