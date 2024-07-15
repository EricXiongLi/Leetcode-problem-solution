class Solution {
    public int longestBeautifulSubstring(String word) {
        String s = "aeiou";
        int[] count = new int[5];
        int start = 0;
        int res = Integer.MIN_VALUE;
        
        for (int end = 0; end < word.length(); end++) {
            char c = word.charAt(end);
            count[s.indexOf(c)]++;
            
            boolean ifWorks = isWorking(word, count, start, end);
            while (!ifWorks) {
                count[s.indexOf(word.charAt(start))]--;
                start++;
                ifWorks = isWorking(word, count, start, end);
            }
            
            boolean containsAll = true;
            for (int i = 0; i < 5; i++) {
                if (count[i] == 0) {
                    containsAll = false;
                    break;
                }
            }
            
            if (containsAll) {
                res = Math.max(res, end - start + 1);
            }
        }
        
        return res == Integer.MIN_VALUE ? 0 : res;
    }
    
    public boolean isWorking(String s, int[] count, int start, int end) {
        if (start <= end - 1 && s.charAt(end) < s.charAt(end - 1)) {
            return false;
        }
        for (int i = 1; i < 5; i++) {
            if (count[i - 1] == 0 && count[i] > 0) {
                return false;
            }
        }
        return true;
    }
}

//tc: O(n)
//sc: O(1)