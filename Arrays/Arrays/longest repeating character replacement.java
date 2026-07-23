/*
Problem: Longest Repeating Character Replacement

Platform: LeetCode #424

Pattern:
Sliding Window

Approach:
1. Use a sliding window with two pointers (left and right).
2. Store the frequency of each character in a HashMap.
3. Keep track of the highest frequency character (maxFreq) in the current window.
4. If the number of characters that need replacement
   (windowSize - maxFreq) becomes greater than k,
   shrink the window from the left.
5. Update the maximum valid window size as the answer.

Why this works:
A window is valid if we can make all its characters the same
by replacing at most k characters. The minimum replacements
needed are:
    windowSize - maxFreq

Time Complexity: O(n)
Space Complexity: O(1)   // O(26) for uppercase English letters
*/

class Solution {

    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxFreq = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            while ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
