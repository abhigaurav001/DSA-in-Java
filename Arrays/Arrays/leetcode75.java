## Approach

I used the **Dutch National Flag Algorithm** to solve this problem in-place.

The array contains only three values: `0`, `1`, and `2`. I use three pointers:

* `low` → maintains the position for `0`
* `mid` → points to the current element being processed
* `high` → maintains the position for `2`

### Algorithm

1. If `nums[mid] == 0`:

   * Swap `nums[low]` and `nums[mid]`.
   * Increment both `low` and `mid`.

2. If `nums[mid] == 1`:

   * It is already in the correct middle section.
   * Simply increment `mid`.

3. If `nums[mid] == 2`:

   * Swap `nums[mid]` and `nums[high]`.
   * Decrement `high`.
   * Do not increment `mid`, because the element coming from `high` still needs to be checked.

We continue until `mid` crosses `high`.

### Complexity

* **Time Complexity:** O(n)
* **Space Complexity:** O(1)

This approach sorts the array in a single pass without using any extra array.
CODE :
class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while(mid <= high) {
            if(numd[mid] == 0) {
                swap(nums , mid , low);
                low++;
                mid++;
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                swap(nums , mid , high);
                high--;
            }
        }
    }
        public void swap(int[] nums , int first, int second) {
            int temp = nums[first];
            nums[first] = nums[second];
            nums[second]  = temp;
        }
}
       
