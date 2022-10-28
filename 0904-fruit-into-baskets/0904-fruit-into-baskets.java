class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = Integer.MIN_VALUE;
        int l = 0;
        int n = fruits.length;
        for (int r = 0; r < n; r++) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}