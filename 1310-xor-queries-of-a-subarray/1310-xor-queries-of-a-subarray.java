class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) prefix[i] = arr[i];
            else {
                prefix[i] = prefix[i - 1] ^ arr[i];
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            if (q[0] == 0) res[i] = prefix[q[1]];
            else {
                res[i] = prefix[q[1]] ^ prefix[q[0] - 1];
            }
        }
        return res;
    }
}