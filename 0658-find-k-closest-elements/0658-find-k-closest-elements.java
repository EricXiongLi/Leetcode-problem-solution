class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (arr[mid] <= x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        int start = r, end = l;
        
        //expand the window: (start, end), exluding
        while(end - start - 1 < k) {
            if (end >= n || (start >= 0 && Math.abs(x - arr[start]) <= Math.abs(x - arr[end]))) {
                start--;
            } else {
                end++;
            }
        }
        
        for (int i = start + 1; i < end; i++) {
            res.add(arr[i]);
        }
        
        return res;
    }
}