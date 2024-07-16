class Solution {
    public int minimumCardPickup(int[] cards) {
        int start = 0;
        int res = Integer.MAX_VALUE;
        Map<Integer, Integer> freq = new HashMap();
        
        for (int end = 0; end < cards.length; end++) {
            freq.put(cards[end], freq.getOrDefault(cards[end], 0) + 1);
            
            while (freq.get(cards[end]) >= 2) {
                res = Math.min(res, end - start + 1);
                freq.put(cards[start], freq.get(cards[start]) - 1);
                start++;
            }
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}