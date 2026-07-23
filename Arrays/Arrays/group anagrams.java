/*
Problem: Group Anagrams

Platform: LeetCode #49

Difficulty: Medium

Pattern:
HashMap + Sorting

Approach:
1. Traverse each string in the input array.
2. Convert the string into a character array.
3. Sort the character array.
4. Use the sorted string as the key in a HashMap.
5. If the key does not exist, create a new list.
6. Add the original string to the corresponding list.
7. Return all the grouped anagrams from the HashMap.

Why this works:
Anagrams contain the same characters with the same frequencies.
After sorting, all anagrams produce the same string, so they
share the same HashMap key and get grouped together.

Time Complexity: O(n * k log k)
- n = number of strings
- k = average length of each string

Space Complexity: O(n * k)
- HashMap stores all strings and their grouped lists.
*/class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if(!map.containsKey(key)) {
                map.put(key , new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
           
