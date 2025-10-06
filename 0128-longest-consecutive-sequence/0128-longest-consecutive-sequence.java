class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    public int longestConsecutive(int[] nums) {
        

        for (int num : nums) {
            set.add(num);
        }
        int res = 0;

        for (int num : set) {
            res = Math.max(res, count(num));
        }

        return res;


        
    }

    public int count(int num) {
        if (map.containsKey(num)) {
            return map.get(num);
        }
        if (!set.contains(num)) {
            map.put(num, 0);
            return 0;
        }
        int cnt;
        cnt = count(num - 1) + 1;
        map.put(num, cnt);
        return cnt;
    }
}