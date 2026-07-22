// LeetCode 76 - Minimum Window Substring
// Approach: Sliding Window + HashMap

import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        // Store frequency of characters required in t
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        // Expand window using right pointer
        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            // Shrink window when it becomes valid
            while (isValid(need, window)) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }


    // Checks whether current window contains all required characters
    public boolean isValid(HashMap<Character, Integer> need,
                           HashMap<Character, Integer> window) {

        for (char ch : need.keySet()) {

            if (window.getOrDefault(ch, 0) < need.get(ch)) {
                return false;
            }
        }

        return true;
    }
}
