class Solution {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        int res = 0;
        Arrays.fill(candy, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) candy[i] = candy[i - 1] + 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) candy[i] = candy[i + 1] + 1;
            res += candy[i];
        }
        res += candy[candy.length - 1];
        return res;       
    }
}