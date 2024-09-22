class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n1 = spells.length, n2 = potions.length;
        int[] res = new int[n1];
        for (int i = 0; i < n1; i++) {
            int l = 0, r = n2 - 1;
            while (l <= r) {
                int m = l + r >> 1;  
                if ((long) potions[m] * spells[i] >= success) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            res[i] = n2 - l;
        }
        
        return res;
    }
}

//tc: O(nlogn + mlogn)
//sc: O(logn)