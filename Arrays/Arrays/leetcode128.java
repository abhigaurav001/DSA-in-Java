Approach :

We need to find the length of the longest consecutive sequence in an unsorted array.

For example:

[100, 4, 200, 1, 3, 2]

The longest consecutive sequence is:

1 → 2 → 3 → 4

So the answer is 4.

Step 1: Use a HashSet

Store all the elements of the array in a HashSet.

This allows us to check whether a number exists in the array in O(1) average time.

Step 2: Find the starting number

For every number num, check whether num - 1 exists in the set.

If num - 1 exists, then num is not the starting point of a sequence.
If num - 1 does not exist, then num is the starting point.

For example:

1, 2, 3, 4

For 1:

0 does not exist → 1 is the starting point.

For 2:

1 exists → skip.

For 3:

2 exists → skip.

For 4:

3 exists → skip.

This prevents us from checking the same sequence multiple times.

Step 3: Build the sequence

Once we find a starting number, keep checking:

num + 1

num + 2

num + 3

and so on until the next number is not present in the set.

For:

[100, 4, 200, 1, 3, 2]

When we reach 1:

1 → 2 → 3 → 4

Length = 4

So the maximum length becomes 4.

Complexity
Time Complexity: O(n) average
Space Complexity: O(n)
Key Idea
  CODE :
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int longest = 1;
        int current = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) continue;
            if(nums[i] == nums[i - 1] + 1) {
                current++;
            }
            else {
                current = 1;
            }
            longest = Math.max(longest, current);
        }
        return longest;
    }
}
