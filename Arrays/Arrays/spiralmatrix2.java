# LeetCode 59 - Spiral Matrix II

## Approach

We have to create an `n x n` matrix and fill it with values from `1` to `n²` in spiral order.

We use four boundaries:

- `top` → topmost remaining row
- `bottom` → bottommost remaining row
- `left` → leftmost remaining column
- `right` → rightmost remaining column

We also use `num = 1` to fill the matrix.

For every layer, we move in four directions:

1. Left → Right
2. Top → Bottom
3. Right → Left
4. Bottom → Top

After completing each direction, we move the corresponding boundary inward:

- `top++`
- `right--`
- `bottom--`
- `left++`

We continue this process until all cells are filled.

### Example

For `n = 3`:

```text
1  2  3
8  9  4
7  6  5


  CODE :
class Solution {
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int num = 1;

        while (top <= bottom && left <= right) {

            // Left -> Right
            for (int col = left; col <= right; col++) {
                matrix[top][col] = num;
                num++;
            }
            top++;

            // Top -> Bottom
            for (int row = top; row <= bottom; row++) {
                matrix[row][right] = num;
                num++;
            }
            right--;

            // Right -> Left
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    matrix[bottom][col] = num;
                    num++;
                }
                bottom--;
            }

            // Bottom -> Top
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    matrix[row][left] = num;
                    num++;
                }
                left++;
            }
        }

        return matrix;
    }
}
