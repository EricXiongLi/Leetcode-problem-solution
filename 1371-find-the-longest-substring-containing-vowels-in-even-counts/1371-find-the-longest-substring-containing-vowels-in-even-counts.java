class Solution {
    public int findTheLongestSubstring(String s) {
        int[] count = new int[5];
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int val = check(s.charAt(i));
            if (val >= 0) count[val] = (count[val] + 1) % 2;
            String counts = Arrays.toString(count);
            map.put(counts, i);
        }
        System.out.println("map" + map);
        int res = 0;
        
        int l1 = 0, l2 = 0;
        count = new int[5];
        if (map.containsKey(Arrays.toString(count))) {
            res = map.get(Arrays.toString(count)) + 1;
        }
        for (int i = 0; i < n; i++) {
            int val = check(s.charAt(i));
            if (val >= 0) count[val] = (count[val] + 1) % 2;
            String counts = Arrays.toString(count);
            if (map.containsKey(counts)) {
                // res = Math.max(map.get(counts) - i, res);
                if (map.get(counts) - i > res) {
                    res = map.get(counts) - i;
                    l1 = i;
                    l2 = map.get(counts);
                }
            }
        }
        System.out.println(l1);
        System.out.println(l2);
        return res;
    }
    
    int check(char c) {
        if (c == 'a') return 0;
        if (c == 'e') return 1;
        if (c == 'i') return 2;
        if (c == 'o') return 3;
        if (c == 'u') return 4;
        return -1;
    }
}