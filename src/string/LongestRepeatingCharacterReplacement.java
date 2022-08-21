package string;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxF = 0, res = 0;
        char[] arr = new char[26];
        while (r < s.length()) {
            arr[s.charAt(r) - 'A']++;
            for (int i = 0; i < 26; i++) {
                maxF = Math.max(arr[i], maxF);
            }
            if (r - l + 1 > k + maxF) {
                arr[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(r - l + 1, res);
            r++;
        }
        return res;
    }
}
