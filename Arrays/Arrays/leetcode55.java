Approach

We use a Greedy approach.

maxReach stores the farthest index we can reach so far.
Traverse the array from left to right.
For every index i:
If i > maxReach, it means the current index is unreachable, so return false.
Otherwise, update the farthest reachable index:
maxReach = Math.max(maxReach, i + nums[i])
If we successfully traverse the entire array, the last index is reachable, so return true.
Example

For nums = [2,3,1,1,4]:

i = 0 → maxReach = 2
i = 1 → maxReach = 4
i = 2 → maxReach = 4
i = 3 → maxReach = 4
i = 4 → maxReach = 8

  code :
class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for(int i = 0; i < nums.length; i++) {
            if( i > maxReach) return false;
            maxReach = Math.max(maxReach , i + nums[i]);
        }
        return true;
    }
}
      
