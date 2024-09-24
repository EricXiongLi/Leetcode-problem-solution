import java.util.Arrays;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // 按宽度升序排序，如果宽度相同，则按高度降序排序
        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        // 使用动态规划查找高度的最长上升子序列
        int n = envelopes.length;
        int[] dp = new int[n];
        int length = 0;
        
        for (int[] envelope : envelopes) {
            int height = envelope[1];
            // 二分查找，找到dp中第一个 >= height 的位置
            int l = 0, r = length;
            while (l < r) {
                int mid = (l + r) / 2;
                if (dp[mid] < height) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            // 更新dp数组
            dp[l] = height;
            // 如果找到了一个新的最大子序列长度，更新长度
            if (l == length) {
                length++;
            }
        }
        
        return length;
    }
}