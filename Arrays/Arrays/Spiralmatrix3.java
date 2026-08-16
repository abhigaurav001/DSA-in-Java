APROACH :
Start position ko answer mein add karo.
Spiral order: Right → Down → Left → Up.
Pehle Right/Down ke liye steps same rahega.
Phir steps++.
Left/Up ke liye new steps use hoga.
Har movement ke baad check karo ki coordinate grid ke andar hai ya nahi.
Valid coordinate ko ans[index] mein store karo aur index++.
Grid ke bahar coordinate ko ignore karo, lekin movement continue rakho.
Jab rows * cols valid coordinates mil jaayein, return kar do.

CODE :
class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int[][] ans = new int[rows * cols][2];

        int index = 0;

        // Add starting coordinate
        ans[index][0] = rStart;
        ans[index][1] = cStart;
        index++;

        int r = rStart;
        int c = cStart;

        int steps = 1;

        while (index < rows * cols) {

            // Move Right
            for (int i = 0; i < steps; i++) {
                c++;

                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    ans[index][0] = r;
                    ans[index][1] = c;
                    index++;
                }
            }

            // Move Down
            for (int i = 0; i < steps; i++) {
                r++;

                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    ans[index][0] = r;
                    ans[index][1] = c;
                    index++;
                }
            }

            // Increase steps after 2 directions
            steps++;

            // Move Left
            for (int i = 0; i < steps; i++) {
                c--;

                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    ans[index][0] = r;
                    ans[index][1] = c;
                    index++;
                }
            }

            // Move Up
            for (int i = 0; i < steps; i++) {
                r--;

                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    ans[index][0] = r;
                    ans[index][1] = c;
                    index++;
                }
            }

            // Increase steps after 2 directions
            steps++;
        }

        return ans;
    }
}
