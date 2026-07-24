LeetCode 647 - Palindromic Substrings
Approach

We generate every possible substring of the given string using two nested loops.

The outer loop selects the starting index of the substring.
The inner loop selects the ending index of the substring.
For every substring, we check whether it is a palindrome using the two-pointer technique.
Two pointers (left and right) start from both ends of the substring.
If the characters at both pointers are equal, move the pointers towards the center.
If a mismatch is found, the substring is not a palindrome.
If all characters match, the substring is a palindrome, so increment the count.
Finally, return the total count of palindromic substrings.
Algorithm
Initialize count = 0.
Generate all possible substrings using two nested loops.
For each substring:
Check if it is a palindrome using two pointers.
If it is a palindrome, increment count.
Return count.
Time Complexity
Generating all substrings: O(n²)
Palindrome check for each substring: O(n)

Overall Time Complexity: O(n³)

Space Complexity

O(1)

Java Code
class Solution {

    public int countSubstrings(String s) {

        int count = 0;

        // Generate all possible substrings
        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {

                if (isPalindrome(s, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isPalindrome(String s, int i, int j) {

        while (i < j) {

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
