class Solution {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                arr[size] = map.get(arr[i]);
                size++;
            }
        }
        int[] nums = Arrays.copyOfRange(arr, 0, size);
        return target.length - longestLIS(nums);
    }
    
    private int longestLIS(int[] nums) {
        //dp[i] : the last item in increasing subsequence of length i + 1;
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length ];
        dp[0] = nums[0];
        int size = 1;
        for (int i = 1; i < nums.length; i++) {
            int insertPos = binarySearch(dp, size, nums[i]);
            dp[insertPos] = nums[i];
            if (insertPos == size) size++;
        }
        return size;
    }
    
    private int binarySearch(int[] nums, int size, int target) {
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}