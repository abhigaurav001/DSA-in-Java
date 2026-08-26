Approach :
using kadane algorithm , start with for loop in array create sum and intialoze with 0 and maxSum =- Integer.MIN_VALUE.
  at every curent nums[i] update sum = sum + nums[i] and update maxSum =  Math.max(sum , maxSum) after this check the main core point that if sum < 0
  means that sum is negative then intiaize sum = 0 again and start with new element .most optimized apprpach for find maximum subarray sum is if sum < 0 then 
  set sum = 0 and start with next element ;
time complexity = 0(n) 
  CODE :
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0 , maxSum = Integer.MIN_VALUE;
        for(int i = 0; i  < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum , sum);
            if(sum < 0) sum = 0;
        }
        return maxSum;
    }
}
    
