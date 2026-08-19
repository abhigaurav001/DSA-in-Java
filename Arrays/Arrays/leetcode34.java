# LeetCode 34 - Find First and Last Position of Element in Sorted Array

## Approach

Since the array is sorted, we can use Binary Search.

We perform Binary Search twice:

1. `findFirst()`
   - If `nums[mid] == target`, store `mid` in `ans`.
   - Continue searching on the left side using `end = mid - 1`.
   - This helps find the first occurrence of the target.

2. `findLast()`
   - If `nums[mid] == target`, store `mid` in `ans`.
   - Continue searching on the right side using `start = mid + 1`.
   - This helps find the last occurrence of the target.

If the target is not found, `ans` remains `-1`.

Finally, return `[first, last]`.

## Complexity

- Time Complexity: O(log n)
- Space Complexity: O(1)

  CODE :
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int First = findFirst(nums , target);
        int Last = findLast(nums , target);
       
        return new int[]{First , Last};
    }
        private int findFirst(int[] nums , int target) {
            int start = 0;
            int end = nums.length - 1;
            int ans = -1;
            while(start <= end) {
                int mid = start + (end - start) /2;
                if(nums[mid] == target) {
                    ans = mid;
                    end = mid - 1;
                } else if(nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return ans;
        }
        private int findLast(int[] nums , int target) {
            int start = 0 , end = nums.length - 1 , ans = -1;
            while(start <= end) {
                int mid = start + (end - start) / 2;
                if(nums[mid] == target) {
                    ans = mid;
                    start = mid + 1;
                } else if(nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return ans;
        }
}
    
