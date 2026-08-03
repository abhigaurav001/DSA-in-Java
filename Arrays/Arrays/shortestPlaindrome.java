# LeetCode 214 - Shortest Palindrome

## Approach

This solution uses the **Knuth-Morris-Pratt (KMP)** algorithm to efficiently find the **longest palindromic prefix** of the given string.

Instead of checking every prefix (which can lead to **O(n²)** time complexity), we use the KMP LPS (Longest Prefix Suffix) array to solve the problem in **O(n)** time.

## Algorithm

1. Reverse the original string.
2. Create a new string:

   ```
   original + "#" + reversed
   ```

   The `#` acts as a separator to prevent unwanted matching between the original and reversed strings.
3. Build the **LPS (Longest Prefix Suffix)** array for the combined string using the KMP preprocessing algorithm.
4. The last value of the LPS array represents the length of the **longest palindromic prefix** in the original string.
5. Extract the remaining suffix of the original string.
6. Reverse this remaining part and prepend it to the original string.
7. Return the resulting shortest palindrome.

## Why KMP?

The KMP preprocessing (LPS array) helps us efficiently determine the longest prefix that is also a suffix in the combined string. Because the second half of the combined string is the reverse of the original, this common prefix corresponds to the longest palindromic prefix.

## Complexity

* **Time Complexity:** O(n)
* **Space Complexity:** O(n)

## Key Concepts

* String Reversal
* KMP (Knuth-Morris-Pratt)
* LPS (Longest Prefix Suffix)
* String Manipulation

## Example

**Input**

```
aacecaaa
```

**Output**

```
aaacecaaa
```

The longest palindromic prefix is `aacecaa`. The remaining part is `a`, which is reversed and added to the front, resulting in the shortest palindrome.
CODE :
class Solution {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() < 1) return s;
        String rev = new StringBuilder(s).reverse().toString();
        String str = s + "#" + rev;
        int[] lps = new int[str.length()];
        int len = 0;
        int i = 1;
        while(i < str.length()) {
            if(str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        int longest = lps[str.length() - 1];
        String remaining = s.substring(longest);
        String add = new StringBuilder(remaining).reverse().toString();
        return add + s;
    }
}
