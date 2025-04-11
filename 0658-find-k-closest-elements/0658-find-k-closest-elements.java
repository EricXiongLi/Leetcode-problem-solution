class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
        int start = l - k - 1, end = l + k + 1;

        while (start < 0) {
                start++;
            } 
            while (end >= n) {
                end--;
            }
        while (end - start + 1  > k) {
            if (Math.abs(arr[start] - x) <= Math.abs(arr[end] - x)) {
                end--;
            } else {
                start++;
            }
        }

        List<Integer> res = new LinkedList<>();
        for (int i = start; i <= end; i++) {
            res.add(arr[i]);
        }

        return res;

        
    }
}

//<=, <=, >
//l, m, r
//r    
//m  l