class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int start = 0;
        int sum = 0;
        int target = k * threshold;
        int res = 0;
        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];
            while (end - start + 1 >= k) {
                if (sum >= target) {
                    res++;
                }
                sum -= arr[start];
                start++;
            }
        }
        
        return res;
    }
}