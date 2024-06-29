class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> res = new ArrayList<>();
        
        int p1 = 0, p2 = 0;
        
        while (p1 < encoded1.length) {
            int minL = Math.min(encoded1[p1][1], encoded2[p2][1]);
            
            int prod = encoded1[p1][0] * encoded2[p2][0];
            int sz = res.size();;
            if (sz > 0 && res.get(sz - 1).get(0) == prod) {
                res.get(sz - 1).set(1, res.get(sz - 1).get(1) + minL);
            } else {
                res.add(Arrays.asList(prod, minL));
            }
            encoded1[p1][1] -= minL;
            encoded2[p2][1] -= minL;
            
            if (encoded1[p1][1] == 0) {
                p1++;
            }
            if (encoded2[p2][1] == 0) {
                p2++;
            }
            
            
        }
        return res;
    }
}