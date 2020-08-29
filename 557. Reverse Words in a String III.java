// light weight 2 ms
class Solution1 {
    public String reverseWords(String s) {
        if (s == null || s.equals("") || s.length() == 0) {
            return s;
        }
        char[] ch = s.toCharArray();
        int start = 0, end = -1;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                reverse(ch, start, end);
                end = i;
                start = i + 1;
                continue;
            }
            end++;
        }
        reverse(ch, start, end);
        return String.valueOf(ch);
    }
    
    private void reverse(char[] ch, int start, int end) {
        while (start < end) {
            char temp = ch[start];
            ch[start++] = ch[end];
            ch[end--] = temp;
        }
    }
}

// 4 ms
class Solution2 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(new StringBuffer(word)
                          .reverse()
                          .toString() + " ");
        }
        return result.toString().trim();
    }
}

// 8 ms
class Solution3 {
    public String reverseWords(String s) {
        if (s.length() == 0) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                result.append(str.reverse().toString());
                result.append(" ");
                str = new StringBuilder();
                continue;
            }
            str.append(s.charAt(i));
        }
        result.append(str.reverse().toString());
        return result.toString();
    }
}

