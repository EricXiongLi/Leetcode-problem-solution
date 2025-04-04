class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // List<Character> list = new ArrayList<>();
        // Collections.addAll(list, "r", "d", "l", "u");
        int r = 0;
        int c = -1;
        int dir = 0;

        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> list = new LinkedList<>();

        while (list.size() < m * n) {
            int newR = r, newC = c;
            if (dir == 0) {
                newC++;
            } else if (dir == 1) {
                newR++;
            } else if (dir == 2) {
                newC--;
            } else {
                newR--;
            }

            if (newR < 0 || newR >= m || newC < 0 || newC >= n || matrix[newR][newC] == -10000) {
                dir = (dir + 1) % 4;
            } else {
                list.add(matrix[newR][newC]);
                matrix[newR][newC] = -10000;
                r = newR;
                c = newC;
            }
            
        }

        return list;
    }
}