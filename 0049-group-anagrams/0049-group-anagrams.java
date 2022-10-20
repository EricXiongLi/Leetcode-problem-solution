class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //0111
        //0111
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] freq = new char[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }
            String sbs = String.valueOf(freq);
            map.computeIfAbsent(sbs, v -> new ArrayList<String>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}

//tc: O(n)
//sc: O(n)