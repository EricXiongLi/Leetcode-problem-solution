class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            if (max == i) res++;
        }
        return res;
    }
}