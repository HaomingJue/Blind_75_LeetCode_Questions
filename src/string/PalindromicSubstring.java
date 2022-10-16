package string;

public class PalindromicSubstring {
    private int count = 0;
    public int countSubstrings(String s) {
        evenPalindrome(s);
        oddPalindrome(s);
        return count;
    }

    private void evenPalindrome(String s) {
        for (int index = 0; index < s.length() - 1; index++) {
            int i = index, j = index + 1;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
                count++;
            }
        }
    }


    private void oddPalindrome(String s) {
        for (int index = 0; index < s.length(); index++) {
            int i = index, j = index;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
                count++;
            }
        }
    }
}
