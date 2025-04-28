class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        Map<Integer, List<Character>> map = new HashMap<>();

        for (char c : freq.keySet()) {
            int val = freq.get(c);

            map.computeIfAbsent(val, v -> new LinkedList<Character>()).add(c);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = s.length(); i >= 1; i--) {
            for (char c : map.getOrDefault(i, new LinkedList<Character>())) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}