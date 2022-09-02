class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int totalSum = Arrays.stream(cardPoints).sum();
        int subsum = 0;
        int left = 0, right = cardPoints.length - k - 1;
        for (int i = left; i <= right; i++) {
            subsum += cardPoints[i];
        }
        int minSum = subsum;
        while (right <= cardPoints.length - 2) {
            subsum -= cardPoints[left];
            left++;
            right++;
            subsum += cardPoints[right];
            minSum = Math.min(minSum, subsum);
        }
        return totalSum - minSum;
    }
}