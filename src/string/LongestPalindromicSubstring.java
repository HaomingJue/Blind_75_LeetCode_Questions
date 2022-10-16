package string;

public class LongestPalindromicSubstring {
    private String ans = "";

    public String longestPalindrome(String s) {
        evenPalindrome(s);
        oddPalindrome(s);
        return ans;
    }

    private void evenPalindrome(String s) {
        for (int index = 0; index < s.length() - 1; index++) {
            int i = index, j = index + 1;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            }
            if (j - i - 1 > ans.length()) {
                ans = s.substring(i + 1, j);
            }
        }
    }


    private void oddPalindrome(String s) {
        for (int index = 0; index < s.length(); index++) {
            int i = index, j = index;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            }
            if (j - i - 1 > ans.length()) {
                ans = s.substring(i + 1, j);
            }
        }
    }
}
