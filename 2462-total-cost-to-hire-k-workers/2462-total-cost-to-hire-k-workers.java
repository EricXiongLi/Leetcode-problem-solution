class Solution {
    public long totalCost(int[] costs, int k, int c) {
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        Set<Integer> deleted = new HashSet<>();
        int n = costs.length;
        int l = c - 1;
        for (int i = 0; i < c; i++) {
            pq1.offer(new int[]{costs[i], i});
        }
        System.out.println("n:" + n);
        long res = 0;
        int r = n - 1;
        for (r = n - 1; r > l && r >= n - c ; r--) {
            pq2.offer(new int[]{costs[r], r});
        }
        r = Math.max(n - c, l - 1);
        while (k >= 0) {
            if (pq1.isEmpty()) {
                int[] min2 = pq2.peek();
                 res += min2[0];
                System.out.println(":" + min2[0]);
                pq2.poll();
                if (l < r - 1) {
                    pq2.offer(new int[]{costs[r - 1], r - 1});
                    r--;
                }
                deleted.add(min2[1]);
                k--;
                System.out.println("am");
            } else if (pq2.isEmpty()) {
                int[] min1 = pq1.peek();
                 res += min1[0];
                System.out.println(":" + min1[0]);
                pq1.poll();
                if (l < r - 1) {
                    pq1.offer(new int[]{costs[l + 1], l + 1});
                    l++;
                }
                deleted.add(min1[1]);
                k--;
                System.out.println("am");
            }
            else {
                // System.out.println("pq1:");
                // for (int[] p : pq1) {
                //     System.out.print("," + p[0]);
                // }
                // System.out.println("pq2:");
                // for (int[] p : pq2) {
                //     System.out.print("," + p[0]);
                // }
                
                
                int[] min1 = pq1.peek();
                int[] min2 = pq2.peek();
                if (min1[0] <= min2[0]) {
                    res += min1[0];
                    pq1.poll();
                    if (l < r - 1) {
                        pq1.offer(new int[]{costs[l + 1], l + 1});
                        l++;
                    }
                   
                    deleted.add(min1[1]);
                    System.out.println("added" + min1[0]);
                    k--;
                } else {
                res += min2[0];
                pq2.poll();
                
                if (l < r - 1) {
                    pq2.offer(new int[]{costs[r - 1], r - 1});
                    r--;
                }
           
                
                deleted.add(min2[1]);
                System.out.println("added" + min2[0]);
                k--;
            }
            }
            if (k == 0) return res;
        }
        // System.out.println("k:"+ k);
        // for (int i = 0; i <= n - 1; i++) {
        //     if (deleted.contains(i)) continue;
        //     res += costs[i];
        //     k--;
        //     if (k == 0) return res;
        // }
        return res;
        
    }
}