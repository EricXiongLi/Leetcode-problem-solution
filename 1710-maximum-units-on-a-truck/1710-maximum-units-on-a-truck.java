class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int res = 0;
        int cur = 0;
        for (int i = 0; i < truckSize; i++) {
            if (cur < boxTypes.length) {
                res += boxTypes[cur][1];
                if (--boxTypes[cur][0] == 0) {
                    cur++;
                }
            }
        }
        return res;
    }
}

//tc: O(n)
//sc: O(1)