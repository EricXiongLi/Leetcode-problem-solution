class Solution {
    public void sortColors(int[] nums) {
        //0, 1, 0, 0,0,0,1,2,2,2
        int n = nums.length;
        
        // [0, i): less 
        //[i, j) equal:
        
//         [k: ]: greater
        int mid = 1;
        int i = 0;
        int j = 0;
        int k = n - 1;
        while (j <= k) {
            if (nums[j] > mid) {
                swap(nums, j, k);
                k--;
            } else if (nums[j] < mid) {
                swap(nums, j, i);
                i++;
                j++;
            } else {
                j++;
            }
        }
    }
    
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}