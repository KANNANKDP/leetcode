class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int length = 0;
        while (i < s.length() && j < s.length()) {
            while (set.contains(chars[j])) {
                set.remove(chars[i]);
                i++;
            }
            set.add(chars[j]);
            length = Math.max(length, j - i + 1);
            j++;
        }
        return length;
    }
}

