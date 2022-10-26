class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int p1 = 0;
        int p2 = 0;
        List<int[]> res = new ArrayList<>();
        int n1 = firstList.length;
        int n2 = secondList.length;
        //       [       ]
        // []  [  ] []  [   ] [  ]
        while (p1 < n1 && p2 < n2) {
            int start1 = firstList[p1][0], end1 = firstList[p1][1];
            int start2 = secondList[p2][0], end2 = secondList[p2][1];
            if (start1 > end2) {
                p2++;
            } else if (end1 < start2) {
                p1++;
            } else {
                int[] cur = new int[]{Math.max(start1, start2), Math.min(end1, end2)};
                res.add(cur);
                if (end1 > end2) {
                    p2++;
                } else {
                    p1++;
                }
            }
        }
        return res.toArray(new int[0][]);
        
    }
}