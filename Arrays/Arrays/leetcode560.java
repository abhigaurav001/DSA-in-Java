class Solution {
    public int subarraySum(int[] nums, int k) {
    HashMap<Integer , Integer> map = new HashMap<>();
    int count = 0;
    int  prefixSum = 0;
    map.put(0 ,1);
    for(int num : nums) {
        prefixSum += num;
        int target = prefixSum - k;
        if(map.containsKey(target)) {
            count += map.get(target);
        }
        map.put(prefixSum , map.getOrDefault(prefixSum , 0) + 1);
    }
    return count;
    }
}
                 Approach :
                 using hashmap first pyt the value of 0 in ma then caalculate everycurrentprefuixSum then target = prefuxSUm - k if map.contains(target) count += map.get(target) 
                   repeat this process until all num not added in prefix sum then return count;
