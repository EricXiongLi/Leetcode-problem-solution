class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] arrs = new int[26];

            for (char c : str.toCharArray()) {
                arrs[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(arrs[i]);
            }

            map.computeIfAbsent(sb.toString(), v -> new ArrayList<String>()).add(str);
        }

        return new ArrayList(map.values());
    }
}