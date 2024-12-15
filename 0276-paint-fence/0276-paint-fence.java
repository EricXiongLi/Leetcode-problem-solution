class Solution {
    public int numWays(int n, int k) {
        //Inspired by wisdomPeak
        //I didn't realize we can use 2 status here
        if (n == 1) return k;
        if (n == 2) return k * k;
        //num of plans when i - 1 and i - 2 share the same color
        int same = k;
        int diff = k * (k - 1);
        
        for (int i = 3; i <= n; i++) {
            int diffTmp = diff;
            int sameTmp = same;
            
            same = diffTmp;
            diff = sameTmp * (k - 1) + diffTmp * (k - 1);
        }
        
        return same + diff;
    }
}

//tc: O(n)
//sc: O(1)

