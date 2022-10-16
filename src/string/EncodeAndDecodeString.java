package string;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeString {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            String length = getLength(str);
            sb.append(length);
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0;
        ArrayList<String> ans = new ArrayList<>();
        while (i < s.length()) {
            int length = Integer.parseInt(s.substring(i, i+3));
            String str = s.substring(i+3, i+3+length);
            i = i + 3 + length;
            ans.add(str);
        }
        return ans;
    }

    private String getLength(String str) {
        int[] lenArr = new int[3];
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            lenArr[i] = length % 10;
            length /= 10;
        }
        for (int e : lenArr) {
            sb.append((char)(e + '0'));
        }
        return sb.toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));

