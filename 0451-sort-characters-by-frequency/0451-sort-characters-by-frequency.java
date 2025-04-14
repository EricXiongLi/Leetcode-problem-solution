class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character>[] buckets = new ArrayList[s.length()];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Character>();
        }
        for (char c : map.keySet()) {
            buckets[map.get(c) - 1].add(c);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = buckets.length - 1; i >= 0; i--) {
            for (Character c : buckets[i]) {
                for (int j = 0; j < map.get(c); j++) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}