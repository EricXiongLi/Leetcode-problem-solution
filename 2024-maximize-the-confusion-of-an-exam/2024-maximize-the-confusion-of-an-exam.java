class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maximize(answerKey, 'T', k), maximize(answerKey, 'F', k));
    }
    
    public int maximize(String s, char c, int k) {
        int start = 0;
        int count = 0;
        int res = 0;
    
        for (int end = 0; end < s.length(); end++) {
            if (s.charAt(end) != c) {
                count++;
            }
            
            while (count > k) {
                if (s.charAt(start) != c) {
                    count--;
                }
                start++;
            }
            
            res = Math.max(res, end - start + 1);
        }
        
        return res;
    }
}

//tc: O(n)
//sc: O(1)