class Solution {
    public int[][] generateMatrix(int n) {
        int count = 1;
        int row = 0, col = 0;
        int[][] res = new int[n][n];
        String dir = "right";
        res[0][0] = 1;
        
        while (count < n * n) {
            count++;
            if (dir.equals("right")) {
                if (col + 1 < n && res[row][col + 1] == 0) {
                    col++;
                } else {
                    dir = "down";
                    row = row + 1;
                }
            } else if (dir.equals("down")) {
                if (row + 1 < n && res[row + 1][col] == 0) {
                    row++;
                } else {
                    dir = "left";
                    col = col - 1;
                }
            } else if (dir.equals("left")) {
                if (col - 1 >= 0 && res[row][col - 1] == 0) {
                    col--;
                } else {
                    dir = "up";
                    row = row - 1;
                }
            } else {
                if (row - 1 >= 0 && res[row - 1][col] == 0) {
                    row--;
                } else {
                    dir = "right";
                    col = col + 1;
                }
            }
            
            res[row][col] = count;
        }
        
        return res;
    }
}