class Solution {
    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> count1 = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            count1.put(c, count1.getOrDefault(c, 0) + 1);
        }

        for (char c : word2.toCharArray()) {
            count2.put(c, count2.getOrDefault(c, 0) + 1);
        }
        Set<Character> set1 = count1.keySet();
        Set<Character> set2 = count2.keySet();
        
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i : count1.values()) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }

        for (int i : count2.values()) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }

        return set1.equals(set2) && map1.equals(map2);
    }
}