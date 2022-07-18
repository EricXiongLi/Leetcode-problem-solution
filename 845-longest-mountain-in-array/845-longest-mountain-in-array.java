class Solution {
    public int longestMountain(int[] arr) {
        int l = arr.length;
        int[] left = new int[l];
        int[] right = new int[l];
        left[0] = 0;
        right[l - 1] = 0;
        for (int i = 1; i < l; i++) {
            left[i] = arr[i] > arr[i - 1] ? left[i - 1] + 1: 0;
            right[l - 1 - i] = arr[l - 1 -i] > arr[l - 1 - i + 1] ? right[l - 1 - i + 1] + 1 : 0;
        }
        int ans = 0;
        for (int i = 1; i < l - 1; i++) {
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }
}

//tc: O(n)
//sc: O(n)