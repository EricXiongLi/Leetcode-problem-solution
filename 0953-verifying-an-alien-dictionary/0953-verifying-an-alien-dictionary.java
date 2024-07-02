class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            if (isBigger(words[i], words[i + 1], map)) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isBigger(String s1, String s2, Map<Character, Integer> map) {
        int n1 = s1.length(), n2 = s2.length();
        boolean containsBiggerChar = false;
        //111, 1112
        
        //121, 1114
        for (int i = 0; i < Math.min(n1, n2); i++) {
            int val1 = map.get(s1.charAt(i)), val2 = map.get(s2.charAt(i));
            if (val1 > val2) {
                return true;
            } else if (val1 < val2) {
                return false;
            }
        }
        
        return n1 > n2;
    }
}

//tc: O(M): m is the total length of characters of words
//sc: O(1); as 26 charcacters in maximum