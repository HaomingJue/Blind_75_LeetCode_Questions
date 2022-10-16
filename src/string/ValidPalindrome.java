package string;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char a = s.charAt(i), b = s.charAt(j);
            if (a == b) {
                i++;
                j--;
            }
            else if (Character.isLetter(a) && Character.isLetter(b)) {
                if (a - b == 'A' - 'a' || b - a == 'A' - 'a') {
                    i++;
                    j--;
                }
                else {
                    return false;
                }
            }
            else if (!Character.isLetter(a) && !Character.isDigit(a)) {
                i++;
            }
            else if (!Character.isLetter(b) && !Character.isDigit(b)) {
                j--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
