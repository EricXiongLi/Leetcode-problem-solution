/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int left = 0, can = 0;
        int p = 1;
        while (p <= n - 1) {
            can = p;
            if (knows(left, can)) {
                left = can;
            } else {
                left = left;
            }
            p++;
        }
        for (int i = 0; i < n; i++) {
            if (i != left) {
                if (knows(left, i) || !knows(i, left)) return -1;
            }
        }
        return left;
    }
}