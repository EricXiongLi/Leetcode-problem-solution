class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] freq = new int[26];
        Arrays.fill(freq, 0);
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            Arrays.fill(freq, 0);
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int num : freq) {
                sb.append("#");
                sb.append(num);
            }
            String key = sb.toString();
            map.computeIfAbsent(key, v -> new ArrayList<String>()).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        res.addAll(map.values());
        return res;
    }
}