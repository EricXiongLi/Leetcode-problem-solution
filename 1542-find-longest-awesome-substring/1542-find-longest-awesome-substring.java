class Solution {
    public int longestAwesome(String s) {
        int count = 0;
        int res = 1;
        Map<Integer, Integer> map = new HashMap<>(); //<freq : index for first occurence>
        map.put(0, -1);
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - '0';
            count ^= (1 << val);
            if (map.containsKey(count)) {
                res = Math.max(res, i - map.get(count));
            } else {
                map.put(count, i);
            }
            for (int j = 0; j <= 9; j++) {
                int cur = count ^ (1 << j);
                if (map.containsKey(cur)) {
                    res = Math.max(res, i - map.get(cur));
                }
            }
        }
        return res;
    }
}