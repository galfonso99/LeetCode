class Solution {
    public static String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
            return "";
        }
        int[] charCount = new int[128];
        for (char c : t.toCharArray()) {
            charCount[c]++;
        }
        
        int left = 0;
        int right = 0;
        int requiredChars = t.length();
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (charCount[rightChar] > 0) {
                requiredChars--;
            }
            charCount[rightChar]--; // Decrement count for all characters
           
            
            while (requiredChars == 0) {
                if (right - left < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                
                // Try to shrink from left
                char leftChar = s.charAt(left);
                charCount[leftChar]++;
                if (charCount[leftChar] > 0) {
                    requiredChars++;
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
