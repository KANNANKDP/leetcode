class Solution {
    public String toLowerCase(String str) {
        char[] s = str.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if ('A' <= s[i] && s[i] <= 'Z')
                s[i] = (char) (s[i] - 'A' + 'a');
        }  
        return String.valueOf(s);
    }
}

