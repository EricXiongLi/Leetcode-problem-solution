class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int price: prices) {
            if (price < min) {
                min = price;
            }
            res = Math.max(res, price - min);
        }
        return res;
    }
}

//tc: O(n)
//sc: O(n)