class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int n = length;
        int[] res = new int[n];
        for (int[] update : updates) {
            res[update[0]] += update[2];
            if (update[1] + 1 < n) {
                res[update[1] + 1] -= update[2];
            }
        }
        
        for (int i = 0; i < n; i++) {
            res[i] += i == 0 ? 0 :res[i- 1];
        }
        
        return res;
    }
}

//tc: O(n)
//sc: O(n)