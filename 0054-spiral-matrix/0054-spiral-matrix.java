class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int row = 0, col = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int movement = 0;
        boolean[][] visited = new boolean[m][n];
        visited[row][col] = true;
        while (res.size() < m * n) {
            res.add(matrix[row][col]);

            //case1: keep direction
            int nextRow = row + dirs[movement][0];
            int nextCol = col + dirs[movement][1];
            if (nextRow >= 0 && nextRow < m & nextCol >= 0 && nextCol < n && !visited[nextRow][nextCol]) {
                row = nextRow;
                col = nextCol;
            } else {
                movement = (movement + 1) % 4;
                row = row + dirs[movement][0];
                col = col + dirs[movement][1];
            }
            if (row >= 0 && row < m && col >= 0 && col < n) {
                visited[row][col] = true;
            }
        }

        return res;
    }
}

//tc: O(m * n)
//sc: O(m * n)