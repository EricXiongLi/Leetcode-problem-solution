class Solution {
    public int minSwaps(int[] data) {
        int oneCount = 0;
        int n = data.length;
        for (int i = 0; i < n; i++) {
            if (data[i] == 1) {
                oneCount++;
            }
        }
        //we use fixed size window here, the needed swap times is the window size - the 1 number in the window
        int size = oneCount;
        int currentOneCount = 0;
        int res = Integer.MAX_VALUE;
        
        for (int i = 0; i < size; i++) {
            if (data[i] == 1) {
                currentOneCount++;
            }
        }
        int start = 0;
        res = Math.min(res, size - currentOneCount);
        for (int end = size; end < n; end++) {
            if (data[start] == 1) {
                currentOneCount--;
            }
            start++;
            if (data[end] == 1) {
                currentOneCount++;
            }
            int currentSwapTimes = size - currentOneCount;
            res = Math.min(res, currentSwapTimes);
            
        }
        
        return res;
    }
}