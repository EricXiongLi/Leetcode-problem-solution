class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int p1 = 0, p2 = 0;
        List<int[]> ans = new LinkedList();
        int l1 = firstList.length, l2 = secondList.length;
        while (p1 < l1 && p2 < l2) {
            if (firstList[p1][0] > secondList[p2][1]) {
                p2++;
            } else if (firstList[p1][1] < secondList[p2][0]) {
                p1++;
            } else {
                int[] temp = new int[2];
                temp[0] = Math.max(firstList[p1][0], secondList[p2][0]);
                temp[1] = Math.min(firstList[p1][1], secondList[p2][1]);
                ans.add(temp);
                if (firstList[p1][1] > secondList[p2][1]) {
                    p2++;
                } else {
                    p1++;
                }
            }
        }
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i][0] = ans.get(i)[0];
            res[i][1] = ans.get(i)[1];
        }
        return res;
    }
}

//tc: O(m + n)
//sc: O(m + n)