# LeetCode 54 - Spiral Matrix

## Approach

The matrix is traversed layer by layer in spiral order.

We maintain four boundaries:

- `top` - first remaining row
- `bottom` - last remaining row
- `left` - first remaining column
- `right` - last remaining column

For every layer, we traverse in four directions:

1. Left → Right
2. Top → Bottom
3. Right → Left
4. Bottom → Top

After completing each direction, the corresponding boundary is moved inward:

- `top++`
- `right--`
- `bottom--`
- `left++`

The process continues until all elements are visited.

## Example

Input:

[
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]

Output:

[1, 2, 3, 6, 9, 8, 7, 4, 5]

## Complexity

Time Complexity: O(m × n)

Space Complexity: O(m × n)

The output list requires O(m × n) space.  

  CODE :
  import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // Traverse from left to right
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            // Traverse from top to bottom
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;

            // Traverse from right to left
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // Traverse from bottom to top
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }

        return result;
    }
}
