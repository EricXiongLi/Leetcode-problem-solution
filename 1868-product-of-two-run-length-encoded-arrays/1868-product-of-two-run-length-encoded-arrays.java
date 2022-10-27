class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> res = new ArrayList<>();
        int p1 = 0, p2 = 0;
        int n1 = encoded1.length, n2  = encoded2.length;
        while (p1 < n1 && p2 < n2) {
            int minFreq = Math.min(encoded1[p1][1], encoded2[p2][1]);
            int curProd = encoded1[p1][0] * encoded2[p2][0];
            encoded1[p1][1] -= minFreq;
            if (encoded1[p1][1] == 0) p1++;
            encoded2[p2][1] -= minFreq;
            if (encoded2[p2][1] == 0) p2++;
            if (res.isEmpty() || res.get(res.size() - 1).get(0) != curProd) {
                res.add(Arrays.asList(curProd, minFreq));
            } else {
                res.get(res.size() - 1).set(1, res.get(res.size() - 1).get(1) + minFreq);
            }
        }
        return res;
    }
}