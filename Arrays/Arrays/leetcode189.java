Array ko right side k positions rotate karna hai.

Maan lo:

nums = [1,2,3,4,5,6,7], k = 3

Target:

[5,6,7,1,2,3,4]

Hum 3 steps karte hain:

Pura array reverse karo

[7,6,5,4,3,2,1]

First k elements reverse karo

[5,6,7,4,3,2,1]

Remaining elements reverse karo

[5,6,7,1,2,3,4]
Important point
k = k % nums.length;

Agar k array ki length se bada hai, to extra rotations useless hain.

Example:

nums.length = 7, k = 10

10 % 7 = 3

Matlab effectively sirf 3 rotations karni hain.

Complexity
Time: O(n) — array ke elements ko limited number of times traverse karte hain.
Space: O(1) — koi extra array use nahi kiya.
Technique: Three-Reversal Algorithm

## Approach

I used the Reversal Algorithm to rotate the array in-place.

Steps:
1. Reverse the entire array.
2. Reverse the first k elements.
3. Reverse the remaining n-k elements.

Before performing the operations, k is reduced using k % n
to handle cases where k is greater than the array length.

### Complexity
Time Complexity: O(n)
Space Complexity: O(1) 
  code:
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums , 0 , nums.length - 1);
        reverse(nums , 0 , k - 1);
        reverse(nums , k , nums.length - 1);
    }
    public void reverse(int[] nums , int start , int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
       
