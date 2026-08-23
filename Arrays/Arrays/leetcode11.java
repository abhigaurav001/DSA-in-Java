Use two pointers: i at the start and j at the end.
Calculate the width between the two pointers.
Find the smaller height between height[i] and height[j].
Calculate the area using:
area = min(height[i], height[j]) * (j - i)
Update maxArea if the current area is greater.
Move the pointer having the smaller height.
Repeat until i and j meet.
Return maxArea.
Complexity
Time: O(n)
Space: O(1)
  CODE :
class Solution {
    public int maxArea(int[] height) {
    int i = 0 , j = height.length - 1;
    int maxArea = 0 ;
    while(i < j) {
        int width = j - i;
         int h = Math.min(height[i] , height[j]);
        int area = width * h;
        maxArea = Math.max(maxArea , area);
        if(height[i] < height[j]) {
            i++;
        }
        else {
            j--;
        }
    }
    return maxArea;
    }
}
        
