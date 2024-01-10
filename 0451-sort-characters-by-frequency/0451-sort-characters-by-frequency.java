class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        List<Character>[] bucket = new ArrayList[s.length()];
        //a -> 2, b -> 2
        for (Character c : map.keySet()) {
            int frequency = map.get(c);
            if (bucket[frequency - 1] == null) {
                bucket[frequency - 1] = new ArrayList<Character>();
            }
            bucket[frequency - 1].add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        
        //bucket[1]: {a, b c}
        //bucket[3]: {d, e, f}
        for (int i = s.length() - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (char c : bucket[i]) {
                for (int j = 0; j < i + 1; j++) {
                    sb.append(c);
                }
            }
            }
        }
        
        return sb.toString();
    }
}