class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        //in lexicographicall order
        quickSort(nums, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }

        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int p = left;
        for (int i = left; i < right; i++) {
            //if (nums[i] > pivot lexicographically)
            if (compareTo(nums[i], pivot) > 0) {
                swap(nums, i, p);
                p++;
            }
        }

        swap(nums, p, right);

        return p;
    }

    public int compareTo(int a, int b) {
        String s1 = String.valueOf(a) + String.valueOf(b);
        String s2 = String.valueOf(b) + String.valueOf(a);

        // return >0 if a > b, which means s1 > s2

        return s1.compareTo(s2);
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}