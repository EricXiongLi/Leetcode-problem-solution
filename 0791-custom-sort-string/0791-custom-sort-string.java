class Solution {
    public String customSortString(String order, String s) {
        
        Map<Character, Integer> freq = new HashMap<>();
        StringBuilder res = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        for (char c : order.toCharArray()) {
            while (freq.getOrDefault(c, 0) > 0) {
                res.append(c);
                freq.put(c, freq.get(c) - 1);
            }
        }
        
        //append the rest letters
        
        for (Character c : freq.keySet()) {
            int count = freq.get(c);
            for (int i = 0; i < count; i++) {
                res.append(c);
            }
        }
        
        return res.toString();
    }
}

// tc: O(n)
// sc: O(n)