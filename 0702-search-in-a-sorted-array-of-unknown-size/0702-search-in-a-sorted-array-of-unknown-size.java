/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    //0, 1, 2
    //l, m    r
//          l. r
//             l
    public int search(ArrayReader reader, int target) {
        //[0, 1, 2, 3, 4, target, 100, 101, 102, 2^]
        int left = 0, right = 10000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left != 10000 && reader.get(left) == target) return left;
        return -1;
    }
}