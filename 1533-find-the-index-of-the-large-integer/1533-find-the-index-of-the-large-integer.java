/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        int n = reader.length();
        int l = 0, r = n - 1;
        return findIndex(l, r, reader);
    }
    
    public int findIndex(int l, int r, ArrayReader reader) {
        while (l < r) {
            int m = l + r >> 1;
            if ((r - l + 1) % 2 == 1) {
                int res = reader.compareSub(l, m - 1, m + 1, r);
                if (res == 0) {
                    return m;
                } else if (res == -1) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                int res = reader.compareSub(l, m, m + 1, r);
                if (res == 1) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
        }
        
        return l;
    }
}