class Solution {
    public void nextPermutation(int[] nums) {
        //1 8 9 5
        //8 5 2
        //1 2 3 4
        //4 3 2 1
        int n = nums.length;
        int k = -1;
        for (int i = n - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                k = i - 1;
                break;
            }
        }
        if (k < 0) {
            reverse(nums, 0, n - 1);
        } else {
            int l = 0;
        for (int i = k + 1; i < n; i++) {
            if (nums[i] > nums[k]) {
                l = i;
            }
        }
        if (k != -1) {
            swap(nums, k, l);
        }
        reverse(nums, k + 1, n - 1);
        }
        
    }
    
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    void reverse(int[] nums, int l, int r) {
        int i = l;
        int j = r;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}