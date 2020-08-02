class Solution1 {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 0) {
            return true;
        }
        
        int lowerCaseCount = 0, upperCaseCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i))) {
                lowerCaseCount++;
            } else {
                upperCaseCount++;
            }
        }
        
        boolean isFirstLetterCapital = Character.isUpperCase(word.charAt(0));
        boolean result = false;
        if (isFirstLetterCapital) {
            if (upperCaseCount == word.length() ||
                upperCaseCount == 1 && lowerCaseCount == word.length() - 1) {
                result = true;
            }
        } else if (lowerCaseCount == word.length()) {
            result = true;
        }
        return result;
    }
}

class Solution2 {
    public boolean detectCapitalUse(String word) {
        int lastCap = -1;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isUpperCase(ch)) {
                if (lastCap + 1 == i) {
                    lastCap++;
                } else {
                    return false;
                }
            }
        }
        
        if (lastCap == -1 ||
            lastCap == 0 ||
            lastCap == word.length() - 1) {
            return true;
        }
        
        return false;
    }
}
