class NumArray {
    int[] arr;
    public NumArray(int[] nums) {
        int n = nums.length;
        arr = new int[n];
        int prefix = 0;
        for (int i = 0; i < n; i++) {
            prefix += nums[i];
            arr[i] = prefix;
        }
    }
    
    public int sumRange(int left, int right) {
        if (left == 0) return arr[right];
        
        return arr[right] - arr[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */