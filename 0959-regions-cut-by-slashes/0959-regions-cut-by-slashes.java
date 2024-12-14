class Solution {
    int[][] matrix;

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        matrix = new int[3 * n][3 * n];
        for (int i = 0; i < n; i++) {
            String s = grid[i];
            int j = 0;
            int k = 0;
            while (j < s.length()) {
                char c = s.charAt(j);
                if (c == ' ') {
                    j++;
                } else if (c == '/') {
                    fulfill1(3 * i, 3 * k);
                    j++;
                } else {
                    fulfill2(3 * i, 3 * k);
                    j++;
                }
                k++;
            }
        }

        for (int i = 0; i < 3 * n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        return numOfIsland(matrix);
    }

    public int numOfIsland(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n * n);
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    if (c + 1 < n && grid[r][c + 1] == 0) {
                        dsu.union(r * n + c + 1, r * n + c);
                    }

                    if (r + 1 < n && grid[r + 1][c] == 0) {
                        dsu.union(r * n + c, (r + 1) * n + c);
                    }
                }
            }
        }

        int res = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0 && dsu.find(r * n + c) == r * n + c) {
                    res++;
                }
            }
        }

        return res;
    }




    public void fulfill1(int r, int c) {
        matrix[r][c + 2] = 1;
        matrix[r + 1][c + 1] = 1;
        matrix[r + 2][c] = 1;
    }

    public void fulfill2(int r, int c) {
        matrix[r][c] = 1;
        matrix[r + 1][c + 1] = 1;
        matrix[r + 2][c + 2] = 1;
    }

    public class DSU {
        int[] parent;
        int[] size;

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];

            Arrays.fill(size, 1);
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            int parentX = parent[x];
            if (x == parentX) {
                return x;
            }
            parent[x] = find(parentX);
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (size[rootX] >= size[rootY]) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            } else {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
        }
    }
}