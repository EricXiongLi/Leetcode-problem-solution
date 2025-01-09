class Solution {
    public int shareCandies(int[] candies, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int can : candies) {
            map.put(can, map.getOrDefault(can, 0) + 1);
        }
        int flavor = 0;

        int left = 0;
        for (int right = 0; right < candies.length; right++) {
            remove(map, candies[right]);
            while (right - left + 1 > k) {
                map.put(candies[left], map.getOrDefault(candies[left], 0) + 1);
                left++;
            }
            if (right - left + 1 == k) {
                flavor = Math.max(flavor, map.size());
            }
        }

        return flavor;
    }

    public void remove(Map<Integer, Integer> map, int num) {
        map.put(num, map.get(num) - 1);
        if (map.get(num) == 0) map.remove(num);
    }
}