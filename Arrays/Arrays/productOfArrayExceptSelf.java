class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        // Prefix product
        ans[0] = 1;

        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // Suffix product
        int right = 1;

        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * right;
            right = right * nums[i];
        }

        return ans;
    }
}   

APPROACH :
We can solve this problem efficiently using the Prefix Product and Suffix Product technique.

The main idea is to calculate the product of all elements to the left and to the right of each index.

1. Prefix Product

First, traverse the array from left to right.

For every index i, store the product of all elements that appear before i in the ans array.

For example:

nums = [1, 2, 3, 4]


ans = [1, 1, 2, 6]

Here:

ans[0] = 1 because there are no elements on the left.
ans[1] = 1
ans[2] = 1 × 2 = 2
ans[3] = 1 × 2 × 3 = 6
2. Suffix Product

Now traverse the array from right to left.

We maintain a variable right, which stores the product of all elements to the right of the current index.

At each index:

ans[i] = ans[i] × right

Then update:

right = right × nums[i]

For nums = [1, 2, 3, 4]:

i = 3 → ans[3] = 6 × 1  = 6
i = 2 → ans[2] = 2 × 4  = 8
i = 1 → ans[1] = 1 × 12 = 12
i = 0 → ans[0] = 1 × 24 = 24

Therefore, the final result is:

[24, 12, 8, 6]
Why This Works

For every index i, the required answer is:

Product of elements on the left × Product of elements on the right

We calculate the left product in the first traversal and multiply it with the right product during the second traversal.

This allows us to solve the problem without using division and also handles arrays containing 0.

Complexity
Time Complexity: O(n)
Extra Space Complexity: O(1) (excluding the output array)
