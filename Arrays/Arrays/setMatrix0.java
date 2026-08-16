Approach:
1. Traverse the entire matrix and find all original zeroes.
2. Mark the corresponding row and column as true.
3. Traverse the matrix again.
4. If the current row or column is marked, set that cell to 0.

Time Complexity: O(m × n)
Space Complexity: O(m + n)

  CODE :
class Solution {
    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        // First pass: find original zeroes
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Second pass: set marked rows and columns to zero
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
