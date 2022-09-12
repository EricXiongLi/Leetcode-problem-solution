class Solution {
    int n;
    
    public int kthSmallest(int[][] matrix, int k) {
//         1,  5,  9
//         10, 11, 13
//         12, 13, 15
//         mid: 11
//         1, 5, 9, 10, 11, 12, 14, 14, 15
            
//         1, 5, 9, 10, 11, 12, 14, 15
// <=cur   1，2， 3，4， 5，  6， 8， 9
// < k     t  t  t  t. t.   t.  f f
        
        n = matrix.length;
        int l = matrix[0][0], r = matrix[n - 1][n - 1];
        while (l <= r) {
            //log(r - l)
            int mid = l + (r - l) / 2;
            if (check(mid, matrix, k)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    
    private boolean check(int mid, int[][] matrix, int k) {
        int startRow = n - 1, startCol = 0;
        int count = 0;
        while (startRow >= 0 && startCol <= n - 1) {
            if (matrix[startRow][startCol] <= mid) {
                count += (startRow + 1);
                startCol++;
                
            } else {
                startRow--;
            }
        }
        return count < k;
    }
}

//tc: O(nlog(r - l))
//sc: O(1)