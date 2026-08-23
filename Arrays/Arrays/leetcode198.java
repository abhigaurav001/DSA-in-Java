## Approach

I used **Dynamic Programming (DP)** to solve this problem.

For each house, we have two choices:

1. **Skip the current house**
   The maximum money remains the same as the previous house:
   `dp[i - 1]`

2. **Rob the current house**
   We cannot rob the adjacent house, so we add the current house's money to the maximum amount we could rob up to `i - 2`:
   `dp[i - 2] + nums[i]`

Therefore, the recurrence relation is:

`dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i])`

### Steps

* `dp[0] = nums[0]`
* `dp[1] = Math.max(nums[0], nums[1])`
* For every house from index `2` onwards, calculate the maximum using the above recurrence.
* The final answer is stored in `dp[n - 1]`.

### Complexity

* **Time Complexity:** O(n)
* **Space Complexity:** O(n)

This approach ensures that no two adjacent houses are robbed while maximizing the total amount of money.
  CODE :
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[]dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0] , nums[1]);
        for(int i = 2 ; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] , nums[i] + dp[i - 2]);
        }
        return dp[n - 1];
    }
}
        

       
