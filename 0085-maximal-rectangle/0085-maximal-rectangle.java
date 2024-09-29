class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //upside, the longest consecutive "1" bar ending at matrix[i][j]
        int[][] bars = new int[m][n];
        
        for (int j = 0; j < n; j++) {
            int size = 0;
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == '1') {
                    size++;
                } else {
                    size = 0;
                }
                bars[i][j] = size;
            }
        }
        
        int res = 0;
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(bars[i]));
            res = Math.max(res, largestRectangle(bars[i]));
        }
        
        return res;
    }
    
    public int largestRectangle(int[] arrs) {
        //absolute increasing stack
        //[value, index]
        Deque<int[]> stack = new ArrayDeque<>();
        int n = arrs.length;
        int[] left = new int[n];
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()[0] >= arrs[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek()[1];
            }
            stack.push(new int[]{arrs[i], i});
        }
        
        stack.clear();
        int[] right = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[0] >= arrs[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek()[1];
            }
            stack.push(new int[]{arrs[i], i});
        }
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, arrs[i] * (right[i] - left[i] - 1));
        }

        return res;
    }
}

//tc: O(m * n)
//sc: O(m * n)