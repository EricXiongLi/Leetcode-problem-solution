class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0, p2 = numbers.length - 1;
        while (p1 < p2) {
            if (numbers[p1] + numbers[p2] == target) {
                return new int[]{p1 +1, p2 + 1};
            } else if (numbers[p1] + numbers[p2] < target) {
                p1++;
            } else {
                p2--;
            }
        }

        return new int[]{-1, -1};
    }
}