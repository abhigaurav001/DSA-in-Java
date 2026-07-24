LeetCode 567 - Permutation in String
Approach

We use the Sliding Window technique along with two HashMaps.

need stores the frequency of every character in s1.
window stores the frequency of characters in the current window of s2.
The window size is always kept equal to s1.length().
Whenever the window becomes larger than s1.length(), remove the leftmost character from the window.
If the frequency of a character becomes 0, remove it from the window map. This is necessary because HashMap.equals() compares both keys and values. Keeping a character with frequency 0 would make the maps unequal.
After every valid window, compare need and window. If both maps are equal, it means the current window is a permutation of s1, so return true.
If no matching window is found, return false.
Time Complexity
Building the need map: O(m)
Sliding through s2: O(n)
Comparing HashMaps: O(k), where k is the number of distinct characters (at most 26 for lowercase English letters).

Overall: O(n) (since k is constant for lowercase English letters).

Space Complexity
O(k) for the two HashMaps.

  CODE : 
  class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        HashMap<Character, Integer> need = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {

            char ch = s2.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            while (right - left + 1 > s1.length()) {

                char leftChar = s2.charAt(left);

                window.put(leftChar, window.get(leftChar) - 1);

                if (window.get(leftChar) == 0) {
                    window.remove(leftChar);
                }

                left++;
            }

            if (need.equals(window)) {
                return true;
            }
        }

        return false;
    }
}
