class Solution {
    public int splitArray(int[] nums, int k) {
        // 0, sumArray
        //[0, sum]
        //isValid(sum) : the minized largest sum <= sum
        
        //0 -> sumAray
//         f, f, f, t, t, t, t, t, t, t,
        //       r lm
        int sum = Arrays.stream(nums).sum();
        int left = Arrays.stream(nums).max().getAsInt();
        int  right = sum;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(nums, mid, k)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    //is it possible that the maximum subarray <= sum with k non empty subarrays
    public boolean isValid(int[] nums, int sum, int k) {
        int count = 1;
        int curSum = 0;
        //[1, 2, 3, 4, 5, 6]
        for (int num : nums) {
            if (num > sum) {
                return false;
            }
            curSum += num;
            if (curSum > sum) {
                count++;
                curSum = num;
                if (count > k) {
                    return false;
                }
            }
        } 
        return true;
    }
}